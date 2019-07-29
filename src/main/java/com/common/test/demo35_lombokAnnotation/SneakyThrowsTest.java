package com.common.test.demo35_lombokAnnotation;

import lombok.SneakyThrows;

/**
 * @Author: jinx
 * @Date: 2019-06-08 11:55
 * @Desc:
 */
public class SneakyThrowsTest {

    public static void main(String[] args) {
        throwEeception();
        System.out.println(111);
    }

    @SneakyThrows
    public static void throwEeception() {
        String s = null;
        String[] split = s.split(",");
        System.out.println(split);
    }
}
