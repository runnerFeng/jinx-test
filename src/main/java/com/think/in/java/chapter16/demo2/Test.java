package com.think.in.java.chapter16.demo2;

/**
 * Desc:
 * Created by jinx on 2017/2/7.
 */
public class Test {

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3, 1}, {1, 3}, {3, 4, 2}};
        int sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i].length;
        }
        System.out.println(sum);
    }


}
