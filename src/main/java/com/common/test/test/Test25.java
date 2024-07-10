package com.common.test.test;

/**
 * @Author jinx
 * @Date 2023/10/31
 * @Desc 合并两个有序数组
 */
public class Test25 {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6}, b = {2, 5, 7, 8, 9};
//        int[] c = merge(a, b);
        int[] c = merge1(a, b);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }

    private static int[] merge1(int[] a, int[] b) {
        int pa = 0, pb = 0, pc = 0;
        int[] c = new int[a.length + b.length];
        while (pa < a.length && pb < b.length) {
            c[pc++] = a[pa] <= b[pb] ? a[pa++] : b[pb++];
        }
        while (pa < a.length) {
            c[pc++] = a[pa++];
        }
        while (pb < b.length) {
            c[pc++] = b[pb++];
        }
        return c;
    }

    private static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < c.length; i++) {
            if (i < a.length) {
                c[i] = a[i];
            } else {
                c[i] = b[c.length - i - 1];
            }
        }
        return sort(c);
    }

    static int[] sort(int[] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length - i - 1; j++) {
                if (c[j] > c[j + 1]) {
                    int temp = c[j];
                    c[j] = c[j + 1];
                    c[j + 1] = temp;
                }
            }
        }
        return c;
    }
}
