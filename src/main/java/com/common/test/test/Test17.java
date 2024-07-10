package com.common.test.test;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Author jinx
 * @Date 2023/9/16
 * @Desc lru(LinkedHashMap)
 */
public class Test17 {

    private int capacity;
    private HashMap<Integer, Integer> map;

//    public Test17(int capacity) {
//        this.capacity = capacity;
//        this.map = new LinkedHashMap<>(16, 0.75f, true);
//    }
//
//
//    public int get(Integer key) {
//        Integer value = map.get(key);
//        return null == value ? -1 : value;
//    }
//
//    public void put(Integer key, Integer value) {
//        if (map.size() > capacity) {
//            map.remove(map.keySet().iterator().next());
//        }
//        map.put(key, value);
//    }


    public Test17(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key) {
     int value = map.get(key);
     return value == 0 ? -1 :value;
    }
    public void put(int key, int value) {
        if(map.size()>capacity){
            map.remove(map.entrySet().iterator().next());
        }
        map.put(key,value);
    }
}


