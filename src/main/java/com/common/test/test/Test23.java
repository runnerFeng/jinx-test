package com.common.test.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jinx
 * @Date 2023/10/31
 * @Desc
 */
public class Test23 {


    public static void main(String[] args) {

//        Map<String,Integer> map = new HashMap<>();
//        map.put(new String("a"),1);
//        map.put(new String("a"),2);
//        map.put("a",3);
//        System.out.println(map.get("a"));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.add(1,4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("--------------------------------");
        for (Integer integer : list) {
            System.out.println(integer);
        }


    }
}
