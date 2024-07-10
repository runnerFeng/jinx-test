package com.leetcode.algorithm.chacpter1.demo1_fibonacci.method2;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2020-12-07 19:06
 * @Desc: 记忆化自底向上
 * 空间复杂度:O(n)
 * 时间复杂度:O(n)
 */
@Slf4j
public class Fibonacci {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int result = fibonacci(80);
        long endTime = System.currentTimeMillis();
        log.info("result:{},cost time:{}", result, endTime - startTime);
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return memorize(n);
    }

    public static int memorize(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 2] + cache[i - 1];
        }
        return cache[n];
    }
}
