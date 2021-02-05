package com.leetcode.algorithm.chacpter2.demo6_lruCache.method1;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Aug
 * @Date: 2021-02-04 14:07
 * @Desc:
 */
@Slf4j
public class LruCache {
    private int capacity;
    private Map<Integer, Node> map;
    private DoubleList cache;

    public DoubleList getCache() {
        return cache;
    }

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(16);
        this.cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).value;
    }

    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    public void put(int key, int value) {
        // contains key
        if (map.containsKey(key)) {
            // delete least recently from cache and map
            cache.remove(map.get(key));
            map.remove(key);
            // add new value
            Node node = new Node(key, value);
            cache.addLast(node);
            map.put(key, node);
            return;
        }
        // compare cache size with capacity if map not contains current key
        if (capacity == cache.getSize()) {
            Node node = cache.removeFirst();
            map.remove(node.key);
        }
        // add new value
        Node newNode = new Node(key, value);
        cache.addLast(newNode);
        map.put(key, newNode);
    }

}
