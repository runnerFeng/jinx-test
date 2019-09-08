package com.common.test.demo0_test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jinx
 * @Date: 2019-09-08 23:14
 * @Desc:
 */
public class Test3 {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
        map.put(i,i*2);
        }
        System.out.println(map.size());
    }
}
