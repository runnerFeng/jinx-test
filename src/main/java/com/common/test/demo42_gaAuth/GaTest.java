package com.common.test.demo42_gaAuth;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-04-25 10:00
 * @Desc:
 */
@Slf4j
public class GaTest {

    public static void main(String[] args) {
        String sec = "CCSMFF5LCSMN5Q3V3ZGC27ZRFWSSIFAU";
        boolean result = HotpUtil.validateGAAuth(sec,"913884");
        log.info("result:{}",result);
    }
}
