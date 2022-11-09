package com.audition.demo7;

import java.util.ArrayList;
import java.util.Collections;
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
            list.add(i);
        }
//        System.out.println(list);

        List<Integer> result = extracted(list);
        while (result.size()>2){
            Collections.reverse(result);
            result = extracted(result);
//            result.clear();
        }
        System.out.println(result);
    }

    private static List<Integer> extracted(List<Integer> oriList) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;  i < oriList.size(); i++) {
            if ((i+1)%3!=0){
                list.add(oriList.get(i));
            }
        }

        System.out.println(list);
        System.out.println(list.size());
        return list;
    }
}
