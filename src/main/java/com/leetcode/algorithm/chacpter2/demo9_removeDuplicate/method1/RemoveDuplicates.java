package com.leetcode.algorithm.chacpter2.demo9_removeDuplicate.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-02-08 10:32
 * @Desc:
 */
@Slf4j
public class RemoveDuplicates {

    public static void main(String[] args) {
        // 初始化
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        log.info("node:{}", node1);
        ListNode head = removeDuplicates(node1);
        log.info("node:{}", head);
    }

    private static ListNode removeDuplicates(ListNode head) {
        // 1.特殊情况
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode expect = dummy;
        // 2.开始比较
        while (head != null && head.next != null) {
            if (dummy.next.val != head.next.val) {
                dummy = dummy.next;
                head = head.next;
            } else {
                // 3.内部元素相等则跳过
                while (head.next != null && dummy.next.val == head.next.val) {
                    head = head.next;
                }
                // 移动head指针,继续和下一个比较
                dummy.next = head.next;
                head = head.next;
            }
        }
        return expect.next;
    }

}
