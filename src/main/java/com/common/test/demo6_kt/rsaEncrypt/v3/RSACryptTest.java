package com.common.test.demo6_kt.rsaEncrypt.v3;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

/**
 * 非对称加密算法RSA测试
 *
 * @author MO8Y
 */
public class RSACryptTest {
    public static void main(String[] args) {
        String password = "qazwsx123当前线程上";
        //在第一次请求时生成公钥与私钥，并放到当前线程上。返回公钥给客户端。
        //session.setAttribute("PD_CurrentRSAKey", map);
        HashMap<String, String> map = RSACrypt.getKeys();
        try {
            //从session上拿到上次生成的密钥
            RSAPublicKey publicKey = RSACrypt.loadPublicKey(map.get("publicKey"));
            RSAPrivateKey privateKey = RSACrypt.loadPrivateKey(map.get("privateKey"));
            System.out.println("公钥：" + map.get("publicKey"));
            System.out.println("私钥：" + map.get("privateKey"));
            System.out.println("明文：" + password);
            //使用私钥解密传输过来的密码
            String passwordjiam = RSACrypt.encrypt(publicKey, password.getBytes());
            System.out.println("加密后：" + passwordjiam);
            String passwordJiem = RSACrypt.decrypt(privateKey, RSACrypt.strToBase64(passwordjiam));
            System.out.println("解密后：" + passwordJiem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
