package com.common.test.test;


/**
 * @Author jinx
 * @Date 2023/10/26
 * @Desc
 */
public class Test20 {
    public static void main(String[] args) {
        int test = 47;
        long start1 = System.currentTimeMillis();
        int result = fibonacci(test);
        long end1 = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("cost1:" + (end1 - start1));
        int result2 = fibonacci2(test);
        long end2 = System.currentTimeMillis();
        System.out.println(result2);
        System.out.println("cost2:" + (end2 - end1));
    }

    private static int fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        return memorize(n);
    }

    private static int memorize(int n) {
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 2] + a[i - 1];
        }
        return a[n];
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
