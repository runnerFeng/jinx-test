package com.audition.demo4;

/**
 * @Author: Aug
 * @Date: 2020-10-09 22:11
 * @Desc:
 */
public class Test2 {

    public static void main(String[] args) {
        int[] arrays = new int[10];
        System.out.println(arrays.length);
        System.out.println(arrays[0]);
        System.out.println(arrays[1]);
        System.out.println(arrays[2]);
        System.out.println(arrays.toString());

        String result = "";
        for (int i = 0; i < arrays.length; i++) {
            int o = arrays[i];
            result += o + ",";

        }
        result = result.substring(0, arrays.length - 1);
        System.out.println(result);
    }
}
