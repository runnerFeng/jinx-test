package com.leetcode.algorithm.demo1_fibonacci;

/**
 * @Author: Aug
 * @Date: 2020-08-07 00:47
 * @Desc:
 */
public class Fibonacci {

    public static void main(String[] args) {
        int result = fibonacci(5);
        System.out.println("result:"+result);
    }

    private static int fibonacci(int n) {
        int result = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n > 1) {
            result = fibonacci(n - 1) + fibonacci(n - 2);
            System.out.println(result);
        }
        return result;
    }
}
