package com.leetcode.algorithm.chacpter8.demo3_kClosest.method1;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: Aug
 * @Date: 2021-02-25 17:57
 * @Desc:
 */
@Slf4j
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(6);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(1);
        queue.offer(2);
        log.info("queue:{}", queue);
        // 加入队列过程形成的二叉树
        // 6,36,364,3546,13465,132654
        List<Integer> list = new ArrayList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            list.add(queue.poll());
        }
        log.info("list:{}", list);
    }

}
