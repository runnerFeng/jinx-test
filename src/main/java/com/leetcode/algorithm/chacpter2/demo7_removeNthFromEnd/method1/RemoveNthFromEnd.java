package com.leetcode.algorithm.chacpter2.demo7_removeNthFromEnd.method1;

/**
 * @Author: fans
 * @Date: 2021/2/6 21:21
 * @Desc:
 */
public class RemoveNthFromEnd {

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


    }

    public static ListNode removeNthFromEnd(ListNode node,int n){
        if (node == null){

        }
        return null;
    }

}
