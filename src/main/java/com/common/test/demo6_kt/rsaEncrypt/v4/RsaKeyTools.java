package com.common.test.demo6_kt.rsaEncrypt.v4;

import com.alibaba.fastjson.JSONObject;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.util.io.pem.PemObject;

import java.io.IOException;
import java.io.StringWriter;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author jinx
 * @date 2018/8/1 16:41
 * Desc: <a href =https://www.cnblogs.com/yqweber/p/4583140.html>
 */
public class RsaKeyTools {
    public static final String PEM_PUBLICKEY = "PUBLIC KEY";

    public static final String PEM_PRIVATEKEY = "PRIVATE KEY";

    public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKbABh+xZIZtmOBtAU0rC+sit9ft8rCkUlFMqQdxdci/U0JMJkgUkQygJ1V/od0ruHn/4FIx0+lYwCaSM/O5sQgwElYJLUnHChAAozFDyGt7An+SC+BTaPsER7Zc1hYg99GeyohZJ0MqrmOLn3mDBxz3FOAWgcbGvA80hWN+6m/wIDAQAB";
    public static final String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAMpsAGH7Fkhm2Y4G0BTSsL6yK31+3ysKRSUUypB3F1yL9TQkwmSBSRDKAnVX+h3Su4ef/gUjHT6VjAJpIz87mxCDASVgktSccKEACjMUPIa3sCf5IL4FNo+wRHtlzWFiD30Z7KiFknQyquY4ufeYMHHPcU4BaBxsa8DzSFY37qb/AgMBAAECgYAcW2buUvt7JxVhJSkvUZi7DkCzcvuWjvjCyhfahyR5rY2rQV8OL2Jp/LK9d5ataOEmjc5LL/Ef3Flh2RK8AACn3m+Cvwvpt61xb9zxS0mrs1oSwrpToAcwwMZFDv1mOogCFDM5mmK7qkNYdgiZXQ+RAr3nY4P1vWG3GUfuhdt7IQJBAPqI0w09BkoTyN2viiXdJTVT7ZsIed2DbptN596jRIUDFeDgxBCjZAT0MYHpYRzItV/9owCfq9muBBtTCAzxB68CQQDO1nrMDZgECG/so70VqWJtwrKGGv0uZZ5kYBCbXg3O56KxYkgRb351Zv6C+jUCnXdGdxgSgdvqc1SkdMuCy9mxAkAlDuQZCzPI9VA66mJG44VDdByrV/+esnhD5KwtlHzoJ+KultCpnWGIEg7YporE1TNu9XeM+hFTa5gT6p5AO87lAkAkt6pg4uDjhmPoDEEawVD5zyBF8jCTtfJiOzN3gUDORAx7lMjaX4KBcOEpeyVB65Yq6iVZ07eobQTPlPQzqeBhAkA1KatTsF1e8fLTNO5sqs132enGC/s5QUu/oYSc9MgOVEGq+jaDU9GafMux86MthXYHO5v7iSMzoakaIXI1kRZ6";


    /**
     * generateRSAKeyPair
     *
     * @param keySize
     * @return
     */
    public static KeyPair generateRSAKeyPair(int keySize) {
        KeyPairGenerator generator = null;
        SecureRandom random = new SecureRandom();
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        try {
            generator = KeyPairGenerator.getInstance("RSA", "BC");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        generator.initialize(keySize, random);

        KeyPair keyPair = generator.generateKeyPair();

        return keyPair;
    }

    /**
     * convertToPemKey
     *
     * @param publicKey
     * @param privateKey
     * @return
     */
    public static String convertToPemKey(RSAPublicKey publicKey,
                                         RSAPrivateKey privateKey) {
        if (publicKey == null && privateKey == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();

        try {
            JcaPEMWriter pemWriter = new JcaPEMWriter(stringWriter);
            if (publicKey != null) {
                pemWriter.writeObject(new PemObject(PEM_PUBLICKEY, publicKey.getEncoded()));
            } else {
                //此处产生的privatekey 的格式是 PKCS#8 的格式
                pemWriter.writeObject(new PemObject(PEM_PRIVATEKEY, privateKey.getEncoded()));
            }
            pemWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

    public static byte[] sign(String data, byte[] privateKey) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        PrivateKey privateKey2 = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance("SHA1WithRSA");
        signature.initSign(privateKey2);
        signature.update(data.getBytes());
        return signature.sign();

    }

    public static boolean verify(String data, byte[] publicKey, byte[] signatureResult) {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey2 = keyFactory.generatePublic(x509EncodedKeySpec);

            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(publicKey2);
            signature.update(data.getBytes());

            return signature.verify(signatureResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //前台的签名结果是将byte 中的一些 负数转换成了正数，
    //但是后台验证的方法需要的又必须是转换之前的
    public static byte[] hexStringToByteArray(String data) {
        int k = 0;
        byte[] results = new byte[data.length() / 2];
        for (int i = 0; i + 1 < data.length(); i += 2, k++) {
            results[k] = (byte) (Character.digit(data.charAt(i), 16) << 4);
            results[k] += (byte) (Character.digit(data.charAt(i + 1), 16));
        }
        return results;
    }

    // 后台测试签名的时候 要和前台保持一致，所以需要将结果转换
    public static String bytes2String(byte[] bytes) {
        StringBuilder string = new StringBuilder();
        for (byte b : bytes) {
            String hexString = Integer.toHexString(0x00FF & b);
            string.append(hexString.length() == 1 ? "0" + hexString : hexString);
        }
        return string.toString();
    }

    public static void main(String[] args) {
        JSONObject object = new JSONObject();
        object.put("calType", "");
        object.put("remark", "测试");
        object.put("target", "");
        object.put("pageNo", "1");
        object.put("pageSize", "20");

        String str = object.toJSONString();
        KeyPair k = generateRSAKeyPair(1024);

        byte[] pubickey = k.getPublic().getEncoded();
        byte[] pirvatekey = k.getPrivate().getEncoded();

        String s = Base64.encode(pubickey);
//        String s = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKbABh+xZIZtmOBtAU0rC+sit9ft8rCkUlFMqQdxdci/U0JMJkgUkQygJ1V/od0ruHn/4FIx0+lYwCaSM/O5sQgwElYJLUnHChAAozFDyGt7An+SC+BTaPsER7Zc1hYg99GeyohZJ0MqrmOLn3mDBxz3FOAWgcbGvA80hWN+6m/wIDAQAB";
        System.out.println("生成的公钥：" + s);

        String s1 = Base64.encode(pirvatekey);
//        String s1 = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAMpsAGH7Fkhm2Y4G0BTSsL6yK31+3ysKRSUUypB3F1yL9TQkwmSBSRDKAnVX+h3Su4ef/gUjHT6VjAJpIz87mxCDASVgktSccKEACjMUPIa3sCf5IL4FNo+wRHtlzWFiD30Z7KiFknQyquY4ufeYMHHPcU4BaBxsa8DzSFY37qb/AgMBAAECgYAcW2buUvt7JxVhJSkvUZi7DkCzcvuWjvjCyhfahyR5rY2rQV8OL2Jp/LK9d5ataOEmjc5LL/Ef3Flh2RK8AACn3m+Cvwvpt61xb9zxS0mrs1oSwrpToAcwwMZFDv1mOogCFDM5mmK7qkNYdgiZXQ+RAr3nY4P1vWG3GUfuhdt7IQJBAPqI0w09BkoTyN2viiXdJTVT7ZsIed2DbptN596jRIUDFeDgxBCjZAT0MYHpYRzItV/9owCfq9muBBtTCAzxB68CQQDO1nrMDZgECG/so70VqWJtwrKGGv0uZZ5kYBCbXg3O56KxYkgRb351Zv6C+jUCnXdGdxgSgdvqc1SkdMuCy9mxAkAlDuQZCzPI9VA66mJG44VDdByrV/+esnhD5KwtlHzoJ+KultCpnWGIEg7YporE1TNu9XeM+hFTa5gT6p5AO87lAkAkt6pg4uDjhmPoDEEawVD5zyBF8jCTtfJiOzN3gUDORAx7lMjaX4KBcOEpeyVB65Yq6iVZ07eobQTPlPQzqeBhAkA1KatTsF1e8fLTNO5sqs132enGC/s5QUu/oYSc9MgOVEGq+jaDU9GafMux86MthXYHO5v7iSMzoakaIXI1kRZ6";
        System.out.println("生成的私钥：" + s1);

        String publicKey = convertToPemKey((RSAPublicKey) k.getPublic(), null);
        String privateKey = convertToPemKey(null, (RSAPrivateKey) k.getPrivate());

        System.out.println("发送给前端的公钥" + publicKey);
        System.out.println("发送给前端的私钥" + privateKey);

        try {
            byte[] signautreResult = sign(str, k.getPrivate().getEncoded());
//            byte[] signautreResult = sign(str, Base64.decode(s1));
            String signatureStr = bytes2String(signautreResult);
            System.out.println("签名之后的串：" + signatureStr);
            byte[] signatureResult2 = hexStringToByteArray(signatureStr);

            boolean b = verify(str, k.getPublic().getEncoded(), signatureResult2);
//            boolean b = verify(str, Base64.decode(s), signatureResult2);
            System.out.print("对比结果：" + b);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sa = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDys3IClDfMncByxqigGmHZKZtX7BOMYIzGfmFgr+SpZohhk3EVz4tGmIGxkvra5u4If0EwCiUn1uGs3ZwMOPxUYu7BHPZQKz8fFYMipwEB83JHJS7teQNWVU8dmTaTsz4wgrZoLvyEwEgGkJBfdboawTE0E6MtwNaPzakQhmyjPwIDAQAB";
        String sb = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDys3IClDfMncByxqigGmHZKZtX7BOMYIzGfmFgr+SpZohhk3EVz4tGmIGxkvra5u4If0EwCiUn1uGs3ZwMOPxUYu7BHPZQKz8fFYMipwEB83JHJS7teQNWVU8dmTaTsz4wgrZoLvyEwEgGkJBfdboawTE0E6MtwNaPzakQhmyjPwIDAQAB";
    }


}
