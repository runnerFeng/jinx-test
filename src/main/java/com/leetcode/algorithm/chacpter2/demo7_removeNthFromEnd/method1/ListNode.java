package com.leetcode.algorithm.chacpter2.demo7_removeNthFromEnd.method1;

import lombok.Data;

/**
 * @Author: Aug
 * @Date: 2021-02-03 10:24
 * @Desc: 单向链表
 * @Desc:
 */
@Data
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }


    public ListNode getNext() {
        return next;
    }


}
