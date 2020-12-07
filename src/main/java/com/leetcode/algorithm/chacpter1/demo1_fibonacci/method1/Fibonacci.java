package com.leetcode.algorithm.chacpter1.demo1_fibonacci.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2020-08-07 00:47
 * @Desc: 递归调用法:f(0)=0,f(1)=1,f(n)=f(n-1)+f(n-2),n>=1;
 * 时间复杂度:O(O(Math.pow(2,n))),n越大,耗时成指数级增长.
 * 空间复杂度:O(n)
 */
@Slf4j
public class Fibonacci {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int result = fibonacci(10);
        long end = System.currentTimeMillis();
        log.info("result:{},cost time:{}", result, end - start);
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
