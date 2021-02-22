package com.leetcode.algorithm.chacpter3.demo2_medianFinder.method1;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Author: Aug
 * @Date: 2021-02-09 11:21
 * @Desc:
 */
public class MedianFinder {

    PriorityQueue<Integer> maxHeap, minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 考虑清楚一个元素和两个元素的情况就好，三个元素后就正常了
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        return (maxHeap.size() == minHeap.size()) ? (maxHeap.peek() + minHeap.peek()) * 0.5 : maxHeap.peek();
    }
}
