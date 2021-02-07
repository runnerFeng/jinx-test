package com.leetcode.algorithm.chacpter2.demo8_removeDuplicates.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-02-07 18:05
 * @Desc: i++，++问题测试
 */
@Slf4j
public class TestI {
    public static void main(String[] args) {
        int i = 0;
        // 先运算再给自己加1
//        log.info("i++:{}",i++);
//        log.info("i++:{}",++i);
        // 先给自己加1，然后再运算
        log.info("++i:{}",++i);

        log.info("i:{}",i);
    }
}
