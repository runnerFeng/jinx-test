package com.leetcode.algorithm.chacpter3.demo7_mergeKLists.method1;

import lombok.Data;

/**
 * @Author: Aug
 * @Date: 2021-03-05 14:28
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

}
