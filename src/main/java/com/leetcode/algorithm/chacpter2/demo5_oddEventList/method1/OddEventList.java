package com.leetcode.algorithm.chacpter2.demo5_oddEventList.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-02-04 09:50
 * @Desc:
 */
@Slf4j
public class OddEventList {

    public static void main(String[] args) {
        // 初始化
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        log.info("before node:{}", node1);
        ListNode listNode = oddEventList(node1);
        log.info("after node:{}", listNode);
    }


    private static ListNode oddEventList(ListNode head) {
        // 1.考虑特殊情况
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, event = head.next, firstEvent = head.next;
        while (event != null && event.next != null) {
            // 先修改next指针指向，此时old.next指向了node3
            odd.next = odd.next.next;
            // 再移动元素odd到node3进行下次循环
            odd = odd.next;

            event.next = event.next.next;
            event = event.next;
        }
        // 最后一个奇数连接第一个偶数
        odd.next = firstEvent;
        return head;

    }

}
