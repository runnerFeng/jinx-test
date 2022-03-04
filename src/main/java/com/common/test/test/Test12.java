package com.common.test.test;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Author jinx
 * @Date 2022/2/17
 * @Desc
 */
@Slf4j
public class Test12 {
    private static final Set<String> channel = new TreeSet<>();

    static {
        channel.add("1");
        channel.add("2");
    }

    public static void main(String[] args) {
        log.info("channel:{}",channel.contains("1"));
        log.info("channel:{}",channel.contains("3"));
    }
}
