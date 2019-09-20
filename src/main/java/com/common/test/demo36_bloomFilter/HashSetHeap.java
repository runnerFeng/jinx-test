package com.common.test.demo36_bloomFilter;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: jinx
 * @Date: 2019-09-16 20:46
 * @Desc:
 */
public class HashSetHeap {

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        Long capacity = 10_000_000L;
        Set<Integer> bucket = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            bucket.add(i);
        }
        System.out.println(bucket.contains(2));
        Long endTime = System.currentTimeMillis();
        // cost 4075ms
        System.out.println("cost time:" + (endTime - startTime));
    }

}
