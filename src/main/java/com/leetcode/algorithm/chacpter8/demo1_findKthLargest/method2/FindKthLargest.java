package com.leetcode.algorithm.chacpter8.demo1_findKthLargest.method2;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Author: Aug
 * @Date: 2021-02-23 17:59
 * @Desc: 优先队列
 */
@Slf4j
public class FindKthLargest {

    public static void main(String[] args) {
        int[] input = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = findKthLargest(input, k);
        log.info("result:{}", result);
    }

    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.peek();
    }

}
