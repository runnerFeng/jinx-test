package com.commonTest.alibabaDeveloperAggrement.demo1;

/**
 * Desc:
 * Created by jinx on 2017/5/16.
 */
public class StringSplit {
    public static void main(String[] args) {
        //使用String的split得到数组时需要校验最后最后一个分隔符后有无内容的检查，否则抛出ArrayIndexOutOfBoundsException
        String s = "a,b,c,,,";
        //这种写法后面的空字符串会被丢弃，使用数组时注意判断最后一个分隔符后是否有内容，否则可能抛出下标越界异常
        String[] arr = s.split(",");
        //这种写法后面的空字符串不会被抛弃，使用数组时不用判断最后一个分隔符后面是否有内容
//        String[] arr = s.split(",",-1);
        System.out.println(arr.length);
        System.out.println(arr[0]);
        System.out.println(arr[2]);
        //此处可能会抛出ArrayIndexOutOfBoundsException
        System.out.println(arr[3]);

        System.out.println("----------------------------");

        String s1 = "a,b,c,,,d";
        String[] arr1 = s1.split(",");
        System.out.println(arr1.length);
        System.out.println(arr1[0]);
        System.out.println(arr1[2]);
        System.out.println(arr1[3]);
        System.out.println(arr1[4]);

    }
}
