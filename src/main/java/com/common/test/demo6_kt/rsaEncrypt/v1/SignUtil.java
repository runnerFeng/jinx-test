package com.common.test.demo6_kt.rsaEncrypt.v1;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author jinx
 * @date 2018/7/27 15:37
 * Desc:
 */
public class SignUtil {

    /**
     * 外部使用
     */
    public static final Integer KEY_TYPE_EXTERNAL = 1;
    /**
     * 内部使用
     */
    public static final Integer KEY_TYPE_INTERNAL = 2;

    private static final int DEFAULT_BUFFER_SIZE = 8192;

    private static final String signType = "RSA";

    private static final String EXTERNAL_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCxen5r+1cidNWv1U7CJzpyrfYGxtS5opIUjxJROw50BAIIdrDJ8aq2VmrqVIyzfc6MXnt/vDMEM2VlfUnv1jZ0B+JhxPMS2SF+NSSb8ObZoxF3qzXBU9xrIEBGwv7WF7E9sD1ZQEOowMyiYluoSBmgTE14WN30bsjhqi3bYaH54YhnrCh7YPKEGM91osCw5G+zWg81LqzromIDdZY2ezoGcw1+kZXM2jzOpjh4z/DDigxiJX3umUmyCK62CnoWJe7KZrjH00OTz+2LT+SksnxVjsFjX1MWLAWJ0d5Tc8xefO0IHLLhUFf0IEX62GLOXebJ+WpoUlF/X5gU5l9n+nUxAgMBAAECggEBAJantMlVAhJtuzcXi1OkmSjgIwh9n/Y02mw5RwNNbmdtP4yPtGK4koFVukxQmV+EW+EsEwnLaEMYneoZALpmzLKSPslftjc5ugS4d+soA86bbih3XZpO5bzKE8X9oPV8Byimgm1Q8B5AC3WMqOGg0qAQJXMTfNYRdNSa8XJY3naOYSTQMIBy+M0IVmlrZptFUX6zBJQoyxCw+gQ8V9YiKKtN/fXp9KofHUxHNUSrsTi9BiSxGHVCyPFxKeqGjYZ6S+8tEynln9uAgEMmuFO8ae4FALZM4wdYT4FCXAbjMvFujDzLgLRn7xkvclErzVa0Rlsm72evZ5VbcIKAvnoLeEECgYEA6Z0I0QdIjpU3bPc3V/UjqB7Bhts1xvdwX9V/E6GrhTMWwJWMriW06F/2oes7AGGmKYiNU1vshm76Kjf/aYphvlYGjdUbeB5jZ+HxffR1EVFzZ2VQPg5umTi3tBcPtk8tBjIWe+23P4A+/cA7mrYo1pORsRYrOhiSqqk3lPz6gRsCgYEAwnxd4x7R0DzrYdK2uqYy/U83/jHbmTD0oNIx3wuGdAu6WkrVJWgtd941p7ofG/LxXW42n8HkNj9UMJPofyWcMuoQMstJh908Y8bJjHwES2HWqeYkK4pgCG9arKjrlnGF9FTGGOmLiDZ7Z0vsYQFy/zUXpKNeUJZsTV2dQ1ZD06MCgYEA33jcyjhRbDPJhW8nffh+V4C0WDCyTNa+pK4ylbD9xrmMdkWZAa4IVJIX9+Rx2HeQ4AJETw2MQT1ACcrvhSJfRhg8xMirMki/hsxYmsiShDKKVspP7E0Z93COKrQ0z40F4PthDsPjm9cuasbNPb4rarhXkjNGvphrFN4y0U7+wykCgYAIiOSl3uheNw4tUM3sCvcZ3qwaX52/b0KM/CxsGVlhJlKbO8V2yseUBxBbt/M9ir/E1d1XzW5yYv0S1KrTSZc9NMBZOkqTx8Wqq0KVA6w8kqKU+iCEOKJWPGzCPvd3tqumOUIoPbd91sY7lj1dVG7zfCT5eKHe73r5Oi54kgSP+QKBgQDGcqvELln4/MSAnp9zyCj2p5+eHXDSKuqvNgeiUSIK1RKDtkFliWto7PvJXGPayDm5R7bpWoSNGDM2Trc8EhqPze9tO0navdXU6AHXld0FR9CZOefXxw/e7GJwcbT432WZTDuBuUO78z4FP3tsfsDGf5whVJBApkTI3/dt3Cy2qQ==";
    private static final String EXTERNAL_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsXp+a/tXInTVr9VOwic6cq32BsbUuaKSFI8SUTsOdAQCCHawyfGqtlZq6lSMs33OjF57f7wzBDNlZX1J79Y2dAfiYcTzEtkhfjUkm/Dm2aMRd6s1wVPcayBARsL+1hexPbA9WUBDqMDMomJbqEgZoExNeFjd9G7I4aot22Gh+eGIZ6woe2DyhBjPdaLAsORvs1oPNS6s66JiA3WWNns6BnMNfpGVzNo8zqY4eM/ww4oMYiV97plJsgiutgp6FiXuyma4x9NDk8/ti0/kpLJ8VY7BY19TFiwFidHeU3PMXnztCByy4VBX9CBF+thizl3myflqaFJRf1+YFOZfZ/p1MQIDAQAB";

    private static final String INTERNAL_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCRwCqpUtXFeUuBHxibtWLnQNJTrq0cEEsiCHGvsOdCzIjsi4cS8FvhyMHLgCkUUC54lehZYDW+XxAcNhB0X9PaFJCaNg0wGN7/OXY3+xViTDtkQHhTevUsZCVktdPpnNM4GZ1hQwmna7jDVMDVV8RyvhbXRenA31ofV+9u6fTCKPdqbxghD7NZX1KmHVAwBoo4DRHhJwPdAWKDl6uiae+/lpKIxBKazKk+/c6vkxvFX1lN2S2RIFQd1Pq4nLmb/eVKq7j8bLpMTmi9Ym3Psh/g5zIbtifZWJymMAXXD3bb5lryxJFe220zDqowXoo6fol00T7qLswpgERzYkNTp4wFAgMBAAECggEADNNTLbk7VHg6+67H1JPekyjyGSkK1KheZC1IC8TOZONovR/+D92UyEaJPyYU91Oi8zuFya+cqxbkbQcY5ZS1KMCchOVyvaPCo8TjsUNn+1Fn/IdrzzTHtFNPsxAJCMqjD5G5dqCWjeP9yzp/CYcCo3I0wlbFnhJJdO6hBCqUPi2HwfQZTZ5GHhFA78f5f9dkz9ICGxm3w6GYVyZEKo9vFrUFytEMJhxRAiBGM8KuOAiy5rmL8Tv38xWCn0yxW2AtskObeYzAyjFM4OLRs1e9xbvdk2Ct7urBtKYKKPD3GUeN94P7laEwtnSLRTn2AwGUQzaoKRSsBGdLARQFaxvwwQKBgQD0EpyLX4V+RLRu+jNMI7wbcC8Sf0CsM05LqKPbymWYg39Jvt5PbQFEeuxePhFjiOJPMC6lURRGBd7dZTjXq464OEqDqaKbr/y9lnVWr7aTwKohhWXiTJDS/rix2F3VuVoysV2oaQlhXmO0r3Zn+zDfIfVKjZ4OmjnfZiYjkqsXkQKBgQCY34fUSBsyzToMa6P/4is92ld0CSvGcjIMH8ZuR/zPWWI82tFBax8b22es5tYEpR7Yg0ztbQTEUHM4UtfvQNiZrPp0tL/OT4T7F1BpBKmvqWB5g/gN0Dktg8mXmjuMhuKp1AaqvfFe5q3P6jwy5SoYu2cDa+6T36cDxpBmSNl7NQKBgHo7W+S8uMkMtWQir1ABUXJYU2qrCgNzSlG/qhgnm4uuxy9yhDk4uPrHqNplsSWs5tGLqsCmA0YyKHOt/rKbu0TtA/w+Fy5rC2MTF76LDx+dzFYvTV/wwlK4uFxwpEWlptNeWi4+NDFsKPjTKrRWaxpEEmj81VwwxqznplAIYuDRAoGAYUqZmnuNe8Zq9C6pQBfDp2jHEZ0ok/JncZnjYppEBf5/6/TjCjxPnx4CnGKIwIoJ2IevtMcWKo581dK7hJQDhcI134KNM5MeMeMDlOKXz6j/MjbP7pKfYR0ndml9DpFlvemnmJCsBdbPtawARe/c28Kg6+eL/eZv15JOohoo9yUCgYBSupBlqoLZSimLSDT8gOMfCBze8FvjhyhWIFK9EbXpx07l+YaeK8OS7zsLGR4wbPoG2Iv8AhGY9l655kiac21rnVP3KkAVUiDVmJcdaMaa2Ixev3nERe+ADxhL6Icuc/fwfHiNrNwtROs4jIQCp98n+8jabdrEExhE8mn4sTOcrw==";
    private static final String INTERNAL_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkcAqqVLVxXlLgR8Ym7Vi50DSU66tHBBLIghxr7DnQsyI7IuHEvBb4cjBy4ApFFAueJXoWWA1vl8QHDYQdF/T2hSQmjYNMBje/zl2N/sVYkw7ZEB4U3r1LGQlZLXT6ZzTOBmdYUMJp2u4w1TA1VfEcr4W10XpwN9aH1fvbun0wij3am8YIQ+zWV9Sph1QMAaKOA0R4ScD3QFig5eromnvv5aSiMQSmsypPv3Or5MbxV9ZTdktkSBUHdT6uJy5m/3lSqu4/Gy6TE5ovWJtz7If4OcyG7Yn2VicpjAF1w922+Za8sSRXtttMw6qMF6KOn6JdNE+6i7MKYBEc2JDU6eMBQIDAQAB";

    private static final String charset = "utf-8";

    public static void main(String[] args) throws Exception {
        JSONObject object = new JSONObject();
//        object.put("calType", "1");
//        object.put("remark", "测试");
//        object.put("target", "");
//        object.put("pageNo", "1");
//        object.put("pageSize", "20");
        object.put("taskId", "");

        String s = rsaSign(object.toString(), 1);
//        String s = rsaSign("{\"calType\":\"\",\"target\":\"\",\"remark\":\"\",\"pageNo\":1,\"pageSize\":20}", 1);
        System.out.println("生成的签名:" + s);

        System.out.println("--------------------");

        String s1 = "637d32fa82aef1f8a593c36a14f505b726ed1b097074d1a08c3d86e11c06a6ec0e7a088927b300bdc509d7d78be59d2c59938e0086511462501b69c193bc617ec29116bf0c74bef77d8cad97c251f2a67a92230e88ec9c8bba4efa2de62476ff22b15763a686afef93875b9fccc13f664f19f6bba1ef1b11ed4d2bb9819cd2338460f43da01cd76958a38bc0ce7e7036b507dc11e18865ef686cd92715920b014a18b8175ea2edbdbb2b9569f30ea7121f09884376ab2b8b22d7e4b63bf03432139a5caf13c2109a1d3309cc4804bdf668e6aa4c4c239964ed5a40cc262dcf906791ef99dd7bf95ec9ee4cfc4cdf8864e0d6fa87d6015807e5456cdaec344c7f";

        boolean b = rsaCheck(object.toString(), s, 1);
        System.out.println(b);
    }

    /**
     * RSA/RSA2 生成签名
     *
     * @param content 请求内容，json格式字符串
     * @return keyType 确认使用那对秘钥对 1.EXTERNAL 2.INTERNAL
     * @throws Exception
     */
    public static String rsaSign(String content, Integer keyType) throws Exception {
        PrivateKey priKey;
        java.security.Signature signature;

        System.out.println("请求参数生成的字符串为:" + content);
        byte[] privateKeyBytes = KEY_TYPE_EXTERNAL.equals(keyType) ? EXTERNAL_PRIVATE_KEY.getBytes() : INTERNAL_PRIVATE_KEY.getBytes();
        if (SignTypeEnum.SIGN_TYPE_RSA.getKey().equals(signType)) {
            priKey = getPrivateKeyFromPKCS8(SignTypeEnum.SIGN_TYPE_RSA.getKey(), new ByteArrayInputStream(privateKeyBytes));
            signature = java.security.Signature.getInstance(SignTypeEnum.SIGN_TYPE_RSA.getValue());
        } else if (SignTypeEnum.SIGN_TYPE_RSA2.getKey().equals(signType)) {
            priKey = getPrivateKeyFromPKCS8(SignTypeEnum.SIGN_TYPE_RSA2.getKey(), new ByteArrayInputStream(privateKeyBytes));
            signature = java.security.Signature.getInstance(SignTypeEnum.SIGN_TYPE_RSA2.getValue());
        } else {
            throw new Exception("不是支持的签名类型:signType=" + signType);
        }
        signature.initSign(priKey);

        if (StringUtil.isEmpty(charset)) {
            signature.update(content.getBytes());
        } else {
            signature.update(content.getBytes(charset));
        }
        byte[] signed = signature.sign();
        String signedResult = bytes2String(signed);
        return signedResult;
//        return new String(Base64.encodeBase64(signed));
    }

    /**
     * 验签方法
     *
     * @param content json格式字符串
     * @param sign
     * @return
     */
    public static boolean rsaCheck(String content, String sign, Integer keyType) throws Exception {
        java.security.Signature signature;
        PublicKey pubKey;

        System.out.println(">>验证的签名为:" + sign);
        System.out.println(">>生成签名的参数为:" + content);

        byte[] publicKeyBytes = KEY_TYPE_EXTERNAL.equals(keyType) ? EXTERNAL_PUBLIC_KEY.getBytes() : INTERNAL_PUBLIC_KEY.getBytes();

        if (SignTypeEnum.SIGN_TYPE_RSA.getKey().equals(signType)) {
            pubKey = getPublicKeyFromX509(SignTypeEnum.SIGN_TYPE_RSA.getKey(), new ByteArrayInputStream(publicKeyBytes));
            signature = java.security.Signature.getInstance(SignTypeEnum.SIGN_TYPE_RSA.getValue());
        } else if (SignTypeEnum.SIGN_TYPE_RSA2.getKey().equals(signType)) {
            pubKey = getPublicKeyFromX509(SignTypeEnum.SIGN_TYPE_RSA2.getKey(), new ByteArrayInputStream(publicKeyBytes));
            signature = java.security.Signature.getInstance(SignTypeEnum.SIGN_TYPE_RSA.getValue());
        } else {
            throw new Exception("不是支持的签名类型 : signType=" + signType);
        }
        signature.initVerify(pubKey);

        if (StringUtil.isEmpty(charset)) {
            signature.update(content.getBytes());
        } else {
            signature.update(content.getBytes(charset));
        }
        return signature.verify((hexStringToByteArray(sign)));
//        return signature.verify(Base64.decodeBase64(sign.getBytes()));
    }

    public static PrivateKey getPrivateKeyFromPKCS8(String algorithm, InputStream ins) throws Exception {
        if (ins == null || StringUtil.isEmpty(algorithm)) {
            return null;
        }
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        byte[] encodedKey = readText(ins).getBytes();
        encodedKey = Base64.decodeBase64(encodedKey);
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
    }

    public static PublicKey getPublicKeyFromX509(String algorithm, InputStream ins) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        StringWriter writer = new StringWriter();
        io(new InputStreamReader(ins), writer, -1);
        byte[] encodedKey = writer.toString().getBytes();
        encodedKey = Base64.decodeBase64(encodedKey);
        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
    }

    private static String readText(InputStream ins) throws IOException {
        Reader reader = new InputStreamReader(ins);
        StringWriter writer = new StringWriter();
        io(reader, writer, -1);
        return writer.toString();
    }

    private static void io(Reader in, Writer out, int bufferSize) throws IOException {
        if (bufferSize == -1) {
            bufferSize = DEFAULT_BUFFER_SIZE >> 1;
        }
        char[] buffer = new char[bufferSize];
        int amount;

        while ((amount = in.read(buffer)) >= 0) {
            out.write(buffer, 0, amount);
        }
    }

    /**
     * 后台测试签名的时候 要和前台保持一致，所以需要将结果转换
     */
    public static String bytes2String(byte[] bytes) {
        StringBuilder string = new StringBuilder();
        for (byte b : bytes) {
            String hexString = Integer.toHexString(0x00FF & b);
            string.append(hexString.length() == 1 ? "0" + hexString : hexString);
        }
        return string.toString();
    }

    /**
     * 前台的签名结果是将byte 中的一些 负数转换成了正数，
     * 但是后台验证的方法需要的又必须是转换之前的
     */
    public static byte[] hexStringToByteArray(String data) {
        int k = 0;
        byte[] results = new byte[data.length() / 2];
        for (int i = 0; i + 1 < data.length(); i += 2, k++) {
            results[k] = (byte) (Character.digit(data.charAt(i), 16) << 4);
            results[k] += (byte) (Character.digit(data.charAt(i + 1), 16));
        }
        return results;
    }

}
