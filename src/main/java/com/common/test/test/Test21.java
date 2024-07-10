package com.common.test.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author jinx
 * @Date 2023/10/26
 * @Desc
 */
public class Test21 {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        System.out.println(set);

        Set set1 = new HashSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        System.out.println(set1);
        System.out.println(set1.equals(set));
    }
}
