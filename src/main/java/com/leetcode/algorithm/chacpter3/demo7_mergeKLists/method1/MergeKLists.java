package com.leetcode.algorithm.chacpter3.demo7_mergeKLists.method1;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

/**
 * @Author: Aug
 * @Date: 2021-03-05 14:21
 * @Desc:
 */
@Slf4j
public class MergeKLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;

        ListNode[] lists = new ListNode[]{node1, node4, node7};
//        ListNode[] lists = new ListNode[]{};
//        ListNode[] lists = new ListNode[]{null};

        ListNode result = mergeKLists(lists);
        log.info("result:{}", result);
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0 ) {
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                queue.offer(node.val);
                node = node.next;
            }
        }

        ListNode dump = new ListNode(0);

        ListNode current = new ListNode(queue.poll());
        dump.next = current;

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            ListNode next = new ListNode(queue.poll());
            current.next = next;
            current = next;
        }
        return dump.next;
    }

}
