package com.leetcode.algorithm.chacpter2.demo7_removeNthFromEnd.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-02-07 09:56
 * @Desc:
 */
@Slf4j
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        // 初始化
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        log.info("node1:{}", node1);
        ListNode listNode = removeNthFromEnd(node1, 2);
        log.info("node1:{}", listNode);

    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        // 1.特殊情况
        if (head == null || head.next == null) {
            return null;
        }
        int s = 1;
        ListNode temp = head, first = head;
        while (temp.next != null) {
            temp = temp.next;
            s++;
        }
        // 注意考虑边界
        for (int i = 0; i < s; i++) {
            if (i == s - n - 1) {
                // 1.修改next指针
                head.next = head.next.next;
                break;
            } else if (i == s - n) {
                // 删除第一个元素，直接把first指针指向第二个元素
                first = head.next;
                break;
            } else {
                // 2.移动元素
                head = head.next;
            }
        }
        return first;
    }

}
