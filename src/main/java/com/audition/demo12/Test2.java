package com.audition.demo12;

import lombok.Data;

/**
 * @Author jinx
 * @Date 2023/10/12
 * @Desc 合并两个排序链表
 */
public class Test2 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
//        Node node3 = new Node(5);
//        Node node4 = new Node(7);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;

        System.out.println(node1);

        Node node5 = new Node(2);
        Node node6 = new Node(4);
//        Node node7 = new Node(6);
//        Node node8 = new Node(8);
//        Node node9 = new Node(12);
        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;


        mergeNode(node1, node5);
        System.out.println(node1);
    }

    private static Node mergeNode(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.value < node2.value) {
            node1.next = mergeNode(node1.next, node2);
            return node1;
        } else {
            node2.next = mergeNode(node2.next, node1);
            return node2;
        }
    }


    @Data
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }

        public void addNode(Node node) {
            this.next = node;
        }

        @Override
        public String toString() {
            return this.value + "" + this.next;
        }

    }
}
