package com.audition.demo11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author：summer
 * @Date：2023/2/3 11:07
 * @Desc：HashMapDeleteTest
 */
public class HashMapDeleteTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(16);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getKey().equals(2)) {
                iterator.remove();
            }
        }
        System.out.println(map);
    }
}
