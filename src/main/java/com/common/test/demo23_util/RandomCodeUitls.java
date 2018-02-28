package com.common.test.demo23_util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.UUID;

/**
 * @title : 随机码生成工具类
 * @describle :
 * <p>
 * Create By yinhaiquan
 * @date 2017/8/31 14:37 星期四
 */
public final class RandomCodeUitls {
    /**
     * 字符集
     */
    private final static String CHARACTERS = "1234567890";
    /**
     * 随机字符串默认长度
     */
    private final static int DEFAULT_LENGTH = 4;

    private static final Random RANDOM = new Random();

    private final static String CHARACTERS_ = "23456789abcdefghigkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";

    /**
     * 生成UUID
     *
     * @return
     */
    public final static String getUUID() {
        return UUID.randomUUID().toString().replaceAll(StringUtils.RAIL, StringUtils.NULL);
    }

    /**
     * 生成随机字符串
     *
     * @return
     * @description: 默认长度4位
     */
    public final static String getRandomString() {
        return getRandomString(0);
    }

    /**
     * 生成随机字符串
     *
     * @param length 指定生成随机字符串长度
     * @return
     * @description: 默认长度4位，输入0长度也默认4位
     */
    public final static String getRandomString(int length) {
        char[] chars = CHARACTERS.toCharArray();
        if (length <= 0) {
            length = DEFAULT_LENGTH;
        }
        int base = String.valueOf(CHARACTERS.length()).length();
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            Double index = Math.random() * Math.pow(10, base);
            result[i] = chars[index.intValue()%CHARACTERS.length()];
        }
        return new String(result);
    }

    public static String randomAlphanumeric(final int count) {
        return RandomStringUtils.random(count, 0, 0, true, true, CHARACTERS_.toCharArray(), RANDOM);
    }
}
