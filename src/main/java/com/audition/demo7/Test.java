package com.audition.demo7;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jinx
 * @Date 2022/6/21
 * @Desc
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (i%3==0){
                list.add(i);
            }
        }
        System.out.println(list);
        System.out.println(list.size());
    }
}
