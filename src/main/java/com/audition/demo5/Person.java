package com.audition.demo5;

import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @Author: fans
 * @Date: 2020/12/9 02:05
 * @Desc:
 */
@Data
public class Person {
    private String name;
    private String nickName;
    private String familyName;

    public static void main(String[] args) {

        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list = list.subList(0,5);
        System.out.println(list.size());
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
