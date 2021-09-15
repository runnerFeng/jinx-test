package com.common.test.demo0_test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jinx
 * @Date: 2019-09-26 16:56
 * @Desc:
 */
public class Test4 {
    public static void main(String[] args) {
        List<String>  list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list.contains("a"));
        for (String s : list) {
            if (s.equals("a")){
                list.remove(s);
            }
        }
    }
}
