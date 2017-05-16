package com.commonTest.alibabaDeveloperAggrement;

/**
 * Desc:
 * Created by jinx on 2017/5/16.
 */
public class StringSplit {
    public static void main(String[] args) {
        //注意ArrayIndexOutOfBoundsException
        String s = "a,b,c,,,";
        String[] arr = s.split(",");
        System.out.println(arr.length);
        System.out.println(arr[0]);
        System.out.println(arr[2]);
        //此处会抛出ArrayIndexOutOfBoundsException
//        System.out.println(arr[3]);

        System.out.println("----------------------------");

        String s1 = "a,b,c,,,d";
        String[] arr1 = s.split(",");
        System.out.println(arr1.length);
        System.out.println(arr1[0]);
        System.out.println(arr1[2]);
//        System.out.println(arr1[3]);
//        System.out.println(arr1[4]);

    }
}
