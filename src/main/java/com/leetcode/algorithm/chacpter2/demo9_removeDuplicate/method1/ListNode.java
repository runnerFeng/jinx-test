package com.leetcode.algorithm.chacpter2.demo9_removeDuplicate.method1;

import lombok.Data;

/**
 * @Author: Aug
 * @Date: 2021-02-03 10:24
 * @Desc: 单向链表
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
