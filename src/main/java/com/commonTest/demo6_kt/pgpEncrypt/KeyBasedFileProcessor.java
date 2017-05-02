package com.commonTest.demo6_kt.pgpEncrypt;

import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.CompressionAlgorithmTags;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.bouncycastle.openpgp.operator.jcajce.*;
import org.bouncycastle.util.io.Streams;

import java.io.*;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Iterator;

/**
 * A simple utility class that encrypts/decrypts public key based encryption
 * files.
 * <p>
 * To encrypt a file: KeyBasedFileProcessor -e [-a|-ai] fileName
 * publicKeyFile.<br>
 * If -a is specified the output file will be "ascii-armored". If -i is
 * specified the output file will be have integrity checking added.
 * <p>
 * To decrypt: KeyBasedFileProcessor -d fileName secretKeyFile passPhrase.
 * <p>
 * Note 1: this example will silently overwrite files, nor does it pay any
 * attention to the specification of "_CONSOLE" in the filename. It also expects
 * that a single pass phrase will have been used.
 * <p>
 * Note 2: if an empty file name has been specified in the literal data object
 * contained in the encrypted packet a file with the name filename.out will be
 * generated in the current working directory.
 */
public class KeyBasedFileProcessor {

    /**
     * 文件解密
     *
     * @param inputFileName   输入文件名称
     * @param keyFileName     私钥文件名称
     * @param passwd          私钥密码
     * @param defaultFileName 默认输出文件名称
     * @throws IOException
     * @throws NoSuchProviderException
     */
    public static void decryptFile(String inputFileName, String keyFileName, char[] passwd,
                                   String defaultFileName) throws IOException, NoSuchProviderException {

        Security.addProvider(new BouncyCastleProvider());

        try (InputStream in = new BufferedInputStream(new FileInputStream(inputFileName));
             InputStream keyIn = new BufferedInputStream(new FileInputStream(keyFileName))) {

            decryptFile(in, keyIn, passwd, defaultFileName);
        }
    }

    /**
     * decrypt the passed in message stream
     */
    private static void decryptFile(InputStream in, InputStream keyIn, char[] passwd,
                                    String defaultFileName) throws IOException, NoSuchProviderException {
        in = PGPUtil.getDecoderStream(in);

        try {
            JcaPGPObjectFactory pgpF = new JcaPGPObjectFactory(in);
            PGPEncryptedDataList enc;

            Object o = pgpF.nextObject();
            //
            // the first object might be a PGP marker packet.
            //
            if (o instanceof PGPEncryptedDataList) {
                enc = (PGPEncryptedDataList) o;
            } else {
                enc = (PGPEncryptedDataList) pgpF.nextObject();
            }

            //
            // find the secret key
            //
            Iterator it = enc.getEncryptedDataObjects();
            PGPPrivateKey sKey = null;
            PGPPublicKeyEncryptedData pbe = null;
            PGPSecretKeyRingCollection pgpSec = new PGPSecretKeyRingCollection(
                    PGPUtil.getDecoderStream(keyIn), new JcaKeyFingerprintCalculator());

            while (sKey == null && it.hasNext()) {
                pbe = (PGPPublicKeyEncryptedData) it.next();

                sKey = findSecretKey(pgpSec, pbe.getKeyID(), passwd);
            }

            if (sKey == null) {
                throw new IllegalArgumentException("secret key for message not found.");
            }

            InputStream clear = pbe.getDataStream(new JcePublicKeyDataDecryptorFactoryBuilder().setProvider("BC").build(sKey));

            JcaPGPObjectFactory plainFact = new JcaPGPObjectFactory(clear);

            Object message = plainFact.nextObject();

            if (message instanceof PGPCompressedData) {
                PGPCompressedData cData = (PGPCompressedData) message;
                JcaPGPObjectFactory pgpFact = new JcaPGPObjectFactory(cData.getDataStream());

                message = pgpFact.nextObject();
            }

            if (message instanceof PGPLiteralData) {
                PGPLiteralData ld = (PGPLiteralData) message;

//                String outFileName = ld.getFileName();
//                if (outFileName.length() == 0) {
//                    outFileName = defaultFileName;
//                }
                File outFile = new File(defaultFileName);
//                if (!outFile.exists()) {
//                    outFile.mkdirs();
//                }

                InputStream unc = ld.getInputStream();
                try (OutputStream fOut = new BufferedOutputStream(new FileOutputStream(outFile))) {
                    Streams.pipeAll(unc, fOut);
                }
            } else if (message instanceof PGPOnePassSignatureList) {
                throw new PGPException("encrypted message contains a signed message - not literal data.");
            } else {
                throw new PGPException("message is not a simple encrypted file - type unknown.");
            }

            if (pbe.isIntegrityProtected()) {
                if (!pbe.verify()) {
                    System.err.println("message failed integrity check");
                } else {
                    System.err.println("message integrity check passed");
                }
            } else {
                System.err.println("no message integrity check");
            }
        } catch (PGPException e) {
            System.err.println(e);
            if (e.getUnderlyingException() != null) {
                e.getUnderlyingException().printStackTrace();
            }
        }
    }

    /**
     * 文件加密
     *
     * @param outputFileName     输出文件名称
     * @param inputFileName      输入文件名称
     * @param encKeyFileName     公钥文件名称
     * @param armor              true表示输出ascii格式文件，false表示输出二进制文件
     * @param withIntegrityCheck 是否需要完整性校验
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws PGPException
     */
    public static void encryptFile(String outputFileName, String inputFileName,
                                   String encKeyFileName, boolean armor, boolean withIntegrityCheck)
            throws IOException, NoSuchProviderException, PGPException {

        Security.addProvider(new BouncyCastleProvider());
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(outputFileName))) {
            PGPPublicKey encKey = readPublicKey(encKeyFileName);
            encryptFile(out, inputFileName, encKey, armor, withIntegrityCheck);
        }
    }

    private static void encryptFile(OutputStream out, String fileName, PGPPublicKey encKey,
                                    boolean armor, boolean withIntegrityCheck) throws IOException, NoSuchProviderException {

        if (armor) {
            out = new ArmoredOutputStream(out);
        }

        try {
            byte[] bytes = compressFile(fileName, CompressionAlgorithmTags.ZIP);

            PGPEncryptedDataGenerator encGen = new PGPEncryptedDataGenerator(
                    new JcePGPDataEncryptorBuilder(PGPEncryptedData.CAST5).setWithIntegrityPacket(withIntegrityCheck).setSecureRandom(new SecureRandom()).setProvider("BC"));

            encGen.addMethod(new JcePublicKeyKeyEncryptionMethodGenerator(encKey).setProvider("BC"));

            try (OutputStream cOut = encGen.open(out, bytes.length)) {
                cOut.write(bytes);
            }

            if (armor) {
                out.close();
            }
        } catch (PGPException e) {
            System.err.println(e);
            if (e.getUnderlyingException() != null) {
                e.getUnderlyingException().printStackTrace();
            }
        }
    }

    private static byte[] compressFile(String fileName, int algorithm) throws IOException {

        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(algorithm);
        PGPUtil.writeFileToLiteralData(comData.open(bOut), PGPLiteralData.BINARY,
                new File(fileName));
        comData.close();
        return bOut.toByteArray();
    }

    private static PGPPrivateKey findSecretKey(PGPSecretKeyRingCollection pgpSec, long keyID, char[] pass)
            throws PGPException, NoSuchProviderException {
        PGPSecretKey pgpSecKey = pgpSec.getSecretKey(keyID);

        if (pgpSecKey == null) {
            return null;
        }

        return pgpSecKey.extractPrivateKey(new JcePBESecretKeyDecryptorBuilder().setProvider("BC").build(pass));
    }

    private static PGPPublicKey readPublicKey(String fileName) throws IOException, PGPException {
        PGPPublicKey pubKey;
        try (InputStream keyIn = new BufferedInputStream(new FileInputStream(fileName))) {
            pubKey = readPublicKey(keyIn);
        }
        return pubKey;
    }

    private static PGPPublicKey readPublicKey(InputStream input) throws IOException, PGPException {
        PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(
                PGPUtil.getDecoderStream(input), new JcaKeyFingerprintCalculator());

        //
        // we just loop through the collection till we find a key suitable for encryption, in the real
        // world you would probably want to be a bit smarter about this.
        //
        Iterator keyRingIter = pgpPub.getKeyRings();
        while (keyRingIter.hasNext()) {
            PGPPublicKeyRing keyRing = (PGPPublicKeyRing) keyRingIter.next();

            Iterator keyIter = keyRing.getPublicKeys();
            while (keyIter.hasNext()) {
                PGPPublicKey key = (PGPPublicKey) keyIter.next();

                if (key.isEncryptionKey()) {
                    return key;
                }
            }
        }

        throw new IllegalArgumentException("Can't find encryption key in key ring.");
    }

//    public static void main(
//            String[] args)
//            throws Exception {
//        Security.addProvider(new BouncyCastleProvider());
//
//        if (args.length == 0) {
//            System.err.println("usage: KeyBasedFileProcessor -e|-d [-a|ai] file [secretKeyFile passPhrase|pubKeyFile]");
//            return;
//        }
//
//        if (args[0].equals("-e")) {
//            if (args[1].equals("-a") || args[1].equals("-ai") || args[1].equals("-ia")) {
//                encryptFile(args[2] + ".asc", args[2], args[3], true, (args[1].indexOf('i') > 0));
//            } else if (args[1].equals("-i")) {
//                encryptFile(args[2] + ".bpg", args[2], args[3], false, true);
//            } else {
//                encryptFile(args[1] + ".bpg", args[1], args[2], false, false);
//            }
//        } else if (args[0].equals("-d")) {
//            decryptFile(args[1], args[2], args[3].toCharArray(), new File(args[1]).getName() + ".out");
//        } else {
//            System.err.println("usage: KeyBasedFileProcessor -d|-e [-a|ai] file [secretKeyFile passPhrase|pubKeyFile]");
//        }
//    }

}