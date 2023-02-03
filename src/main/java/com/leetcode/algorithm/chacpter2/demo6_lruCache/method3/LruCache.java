package com.leetcode.algorithm.chacpter2.demo6_lruCache.method3;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author：summer
 * @Date：2023/2/3 11:40
 * @Desc： accessOder = true,使用访问顺序，每次访问（查询/新增）时元素都放入链表尾部
 */
public class LruCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(16, 0.75f, true);

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        return value != null ? value : -1;
    }

    public void put(int key, int value) {
        if (map.size() >= capacity) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }

    /**
     * for testing purposes
     */
    public Map<Integer, Integer> getMap() {
        return map;
    }
}
