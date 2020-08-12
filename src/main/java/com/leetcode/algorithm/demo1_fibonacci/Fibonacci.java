package com.leetcode.algorithm.demo1_fibonacci;

/**
 * @Author: Aug
 * @Date: 2020-08-07 00:47
 * @Desc:
 */
public class Fibonacci {

    public static void main(String[] args) {
        int result = fibonacci(5);
        System.out.println("result:" + result);
    }

    private static int fibonacci(int n) {
        if (n < 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
