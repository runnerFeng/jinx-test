package com.commonTest.alibabaDeveloperAggrement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Desc:
 * Created by jinx on 2017/5/18.
 */
public class ToArray {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        //1.此处String[]传入的arr大小就是list.size() 2.toArray()方法一定用带参数的方法,无参返回的是Object[],若强转其他类型数组有ClasCastException
        String[] arr = new String[list.size()];
        arr = list.toArray(arr);
        for (String s : arr) {
            System.out.println(s);
        }

        List list1 = Arrays.asList(arr);
        //Arrays.asList()方法把数组转为集合时不能使用其修改相关的方法，否则抛出UnsupportedOperationException,asList方法返回的是一个Arrays的内部类，并没有实现集合的修改方法
//        list1.remove(0);
        System.out.println("--------------");
        //修改arr的值，list1也会改变
        arr[0] = "5";
        System.out.println(list1.get(0));
    }
}
