package com.leetcode.algorithm.chacpter2.demo4_reverseKGroup.method1;

import lombok.extern.slf4j.Slf4j;


/**
 * @Author: Aug
 * @Date: 2021-02-03 10:23
 * @Desc: <link https://www.cnblogs.com/labuladong/p/12320488.html/>
 */
@Slf4j
public class ReverseKGroup {
    public static void main(String[] args) {
        // 初始化
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        log.info("node i:{}", node1);
        reverse(node1);
        log.info("node i:{}", node3);

//        reverse(node1, node2);
//        log.info("node i:{}", node1);

        reverseKGroup(node1, 2);
        log.info("node i:{}", node2);

    }

    /**
     * 链表的反转
     *
     * @param node
     */
    private static ListNode reverse(ListNode node) {
        ListNode pre = null, current = node, next;
        while (current != null) {
            next = current.next;
            current.next = pre;
            // 将处理好的current作为后面的current
            pre = current;
            // 移动current指针到下一个元素
            current = next;
        }
        return pre;
    }

    /**
     * 部分反转
     *
     * @param node
     * @param node2
     */
    private static ListNode reverse(ListNode node, ListNode node2) {
        ListNode pre = null, current = node, next;
        while (current != node2) {
            // 暂存
            next = current.next;
            // 移动指针
            current.next = pre;
            // 移动current,next
            pre = current;
            current = next;
        }
        return pre;
    }

    /**
     * k长度反转
     *
     * @param head
     * @param k
     * @return
     */
    private static ListNode reverseKGroup(ListNode head, int k) {
        // 先考虑特殊情况
        if (head == null) {
            return null;
        }
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 部分反转
        ListNode newHead = reverse(a, b);
        // 递归连接每个部分
        a.next = reverseKGroup(b, k);
        // 第一次返回的newHead没用，后续返回的newHand才会用作连接节点
        return newHead;
    }

}
