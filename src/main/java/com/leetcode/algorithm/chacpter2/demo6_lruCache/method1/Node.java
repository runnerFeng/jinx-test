package com.leetcode.algorithm.chacpter2.demo6_lruCache.method1;

/**
 * @Author: Aug
 * @Date: 2021-02-05 14:06
 * @Desc: 双链表节点
 */
public class Node {
    int value;
    int key;
    Node pre, next;

    public Node(int value, int key) {
        this.value = value;
        this.key = key;
    }

}
