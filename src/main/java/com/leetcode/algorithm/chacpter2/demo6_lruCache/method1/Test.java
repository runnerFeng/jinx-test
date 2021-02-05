package com.leetcode.algorithm.chacpter2.demo6_lruCache.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-02-05 16:49
 * @Desc:
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);

        int value = lruCache.get(1);
        log.info("value:{}", value);

        int value2 = lruCache.get(2);
        log.info("value2:{}", value2);

        int value3 = lruCache.get(3);
        log.info("value3:{}", value3);


        lruCache.put(3,3);

        int value4 = lruCache.get(2);
        log.info("value4:{}", value4);

        Node head = lruCache.getCache().getHead();

        log.info("size:{}", lruCache.getCache().getSize());
        log.info("head:{}", head.value);
        log.info("head.next:{}", head.next.value);
        log.info("head.next.next:{}", head.next.next.value);

        Node tail = lruCache.getCache().getTail();
        log.info("tail.pre:{}", tail.pre.value);

        int value5 = lruCache.get(1);
        log.info("value5:{}", value5);

    }
}
