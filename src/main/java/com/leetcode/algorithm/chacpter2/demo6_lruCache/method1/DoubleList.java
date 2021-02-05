package com.leetcode.algorithm.chacpter2.demo6_lruCache.method1;

/**
 * @Author: Aug
 * @Date: 2021-02-05 14:09
 * @Desc: 构造双链表
 */
public class DoubleList {
    private Node head, tail;
    private int size;


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    /**
     * addLast
     */
    public void addLast(Node node) {
        node.next = tail;
        // NOTE:node.pre = head写法第一次赋值是正确的,但是这样添加第二个节点时会将node.pre直接指向head，跳过了
        // 之前添加的节点，所以此处参考物应该为最近的tail，而不是最远的head
//        node.pre = head;（错误写法）
        node.pre = tail.pre;

        tail.pre.next = node;
        tail.pre = node;
        size++;
    }

    public int getSize() {
        return size;
    }

    /**
     * removeFirst
     */
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    /**
     * remove
     *
     * @param node
     */
    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }
}
