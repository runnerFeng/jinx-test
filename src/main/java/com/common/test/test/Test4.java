package com.common.test.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: fans
 * @Date: 2021/6/3 22:48
 * @Desc:
 */
@Slf4j
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            log.info("i:{}",i);
            Thread.sleep(100);
        }
    }
}
