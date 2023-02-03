package com.audition.demo11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author：summer
 * @Date：2023/2/3 11:06
 * @Desc：ArrayListDeleteTest
 */
public class ArrayListDeleteTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next.equals(3)){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
