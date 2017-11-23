package com.common.test.alibabaDeveloperAggrement.demo1;

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
        //2.使用toArray 带参方法，入参分配的数组空间不够大时，toArray方法内部将重新分配内存空间，并返回新数组地址；如果数组元素大于实际所需，下标为[ list.size() ]的数组
        //元素将被置为null，其它数组元素保持原值，因此最好将方法入参数组大小定义与集合元素个数一致。
        String[] arr = new String[list.size()];
        arr = list.toArray(arr);
        for (String s : arr) {
            System.out.println(s);
        }

        List list1 = Arrays.asList(arr);
        //Arrays.asList()方法把数组转为集合时不能使用其修改相关的方法，否则抛出UnsupportedOperationException,asList方法返回的是一个Arrays的内部类，并没有实现集合的修改方法
        //Arrays.asList体现的是适配器模式，只是转换接口，后台的数据仍是数组
//        list1.remove(0);
        System.out.println("--------------");
        //修改arr的值，list1也会改变
        arr[0] = "5";
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            System.out.println(s);
        }

        System.out.println("-------------");
        // ArrayList的subList结果不可强转成ArrayList，否则会抛出 ClassCastException异常，即java.util.RandomAccessSubList cannot be cast to java.util.ArrayList.
        // 说明：subList返回的是ArrayList的内部类SubList，并不是ArrayList，而是ArrayList的一个视图，对于SubList子列表的所有操作最终会反映到原列表上
        // List<String> list2 = list.subList(0,3);
        ArrayList<String> list2 = (ArrayList<String>) list.subList(0, 3);
        for (int i = 0; i < list2.size(); i++) {
            String s = list2.get(i);
            System.out.println(s);
        }
    }
}
