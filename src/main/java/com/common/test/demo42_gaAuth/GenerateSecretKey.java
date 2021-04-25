package com.common.test.demo42_gaAuth;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base32;

/**
 * @Author: Aug
 * @Date: 2021-04-25 10:12
 * @Desc:
 */
@Slf4j
public class GenerateSecretKey {

    public static final String gaSecretKey = "bytes-long-AES-Key-Ga-Secret-Key";

    public static void main(String[] args) {
        String iv= RandomUtil.createRandomString(RandomUtil.HEX_DIGITS, RandomUtil.AES_IV_LENGTH);
        String bindData = new Base32().encodeAsString(RandomUtil.createRandomBytes(20));
        String encrypt  = "AES:" + iv +AESUtil.encrypt(bindData,gaSecretKey, iv);
        log.info("bindData:{},encrypt:{}",bindData,encrypt);
    }
}
