package com.common.test.demo6_kt.rsaEncrypt.v2;

/**
 * @author jinx
 * @date 2018/8/1 16:03
 * Desc:
 */
public class RSATest {
    public static void main(String[] args) throws Exception {
        String filepath = "f:/rsaTest/";

//        RSAEncryptUtil.genKeyPair(filepath);


//        System.out.println("--------------公钥加密私钥解密过程-------------------");
//        String plainText="ihep_公钥加密私钥解密";
//        //公钥加密过程
//        byte[] cipherData=RSAEncryptUtil.encrypt(RSAEncryptUtil.loadPublicKeyByStr(RSAEncryptUtil.loadPublicKeyByFile(filepath)),plainText.getBytes());
//        String cipher=Base64.encode(cipherData);
//        //私钥解密过程
//        byte[] res=RSAEncryptUtil.decrypt(RSAEncryptUtil.loadPrivateKeyByStr(RSAEncryptUtil.loadPrivateKeyByFile(filepath)), Base64.decode(cipher));
//        String restr=new String(res);
//        System.out.println("原文："+plainText);
//        System.out.println("加密："+cipher);
//        System.out.println("解密："+restr);
//        System.out.println();

//        System.out.println("--------------私钥加密公钥解密过程-------------------");
//        plainText="ihep_私钥加密公钥解密";
//        //私钥加密过程
//        cipherData=RSAEncryptUtil.encrypt(RSAEncryptUtil.loadPrivateKeyByStr(RSAEncryptUtil.loadPrivateKeyByFile(filepath)),plainText.getBytes());
//        cipher=Base64.encode(cipherData);
//        //公钥解密过程
//        res=RSAEncryptUtil.decrypt(RSAEncryptUtil.loadPublicKeyByStr(RSAEncryptUtil.loadPublicKeyByFile(filepath)), Base64.decode(cipher));
//        restr=new String(res);
//        System.out.println("原文："+plainText);
//        System.out.println("加密："+cipher);
//        System.out.println("解密："+restr);
//        System.out.println();

        System.out.println("---------------私钥签名过程------------------");
//        String content="ihep_这是用于签名的原始数据";
        String content = "{\"calType\":\"\",\"pageNo\":\"1\",\"pageSize\":\"20\",\"remark\":\"测试\",\"target\":\"\"}";

        String signstr1 = "dc9PKtLLYRmMB1cJHrT5C+YvB3MB5d6Q+EZhoXRQfj4c7vxwJAywNsZmbXZVKk1B\n" +
                "F1q26SC8DmPhT9aiLVeXEXPT7Z3uua6YLFcBsDcOVsP1O5YGqHe4hfRiRlu8+hnG\n" +
                "/kWXACgN7z1dXhO6abw/Rs3xx9KFkhQ1F23+ntc+6Dk=";
        String signstr = RSASignatureUtil.sign(content, RSAEncryptUtil.loadPrivateKeyByFile(filepath));
        System.out.println("签名原串：" + content);
        System.out.println("签名串：" + signstr);
        System.out.println();

        System.out.println("---------------公钥校验签名------------------");
        System.out.println("签名原串：" + content);
        System.out.println("签名串：" + signstr);

        System.out.println("验签结果：" + RSASignatureUtil.doCheck(content, signstr, RSAEncryptUtil.loadPublicKeyByFile(filepath)));
        System.out.println();

    }
}
