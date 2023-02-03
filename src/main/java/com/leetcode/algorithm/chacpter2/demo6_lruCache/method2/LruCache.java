package com.leetcode.algorithm.chacpter2.demo6_lruCache.method2;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Aug
 * @Date: 2021-02-05 18:00
 * @Desc: LinkedHashMap put元素到链表尾部，remove元素为链表头部，符合队列先进先出特点
 *        accessOrder = false,默认值,使用插入顺序
 */
public class LruCache {
    private int capacity;
    private Map<Integer, Integer> map = new LinkedHashMap<>(16);

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Integer remove = map.remove(key);
        map.put(key, remove);
        return remove;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // delete least recently
            map.remove(key);
        }
        // 此处等号不要忘记
        if (map.size() >= capacity) {
            // remove链表头部是最久未被使用的key
            map.remove(map.keySet().iterator().next());
        }
        // 将新元素添加到尾部
        map.put(key, value);
    }

    /**
     * 该方法为测试使用
     *
     * @return
     */
    public Map<Integer, Integer> getMap() {
        return map;
    }
}
