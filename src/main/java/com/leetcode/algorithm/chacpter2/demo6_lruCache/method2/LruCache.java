package com.leetcode.algorithm.chacpter2.demo6_lruCache.method2;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Aug
 * @Date: 2021-02-05 18:00
 * @Desc: LinkedHashMap put元素到链表尾部，remove元素为链表头部，符合队列先进先出特点
 */
public class LruCache {
    private int capacity;
    private Map<Integer, Integer> map = new LinkedHashMap(16);

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key);
    }

    private void makeRecently(int key) {
        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // delete least recently and add new value
            map.remove(key);
            map.put(key, value);
            return;
        }
        if (map.size() >= capacity) {
            // remove链表头部是最久未被使用的key
            int oldKey = map.keySet().iterator().next();
            map.remove(oldKey);
        }
        // 将新元素添加到尾部
        map.put(key, value);
    }
}
