package com.leetcode.algorithm.chacpter8.demo3_kClosest.method1;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: fans
 * @Date: 2021/2/24 23:24
 * @Desc:
 */
@Slf4j
public class KClosest {

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int K = 1;
        int[][] result = kClosest(points, K);
        log.info("result:{}", result);
    }

    private static int[][] kClosest(int[][] points, int K) {
        // 小根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int tmp = o1[0] * o1[0] + o1[1] * o1[1] - (o2[0] * o2[0] + o2[1] * o2[1]);
                return tmp;
            }
        });
        for (int i = 0; i < points.length; i++) {
            if (queue.peek() != null) {
                queue.offer(points[i]);
            } else {
                queue.offer(points[i]);
            }
        }

        int[][] help = new int[K][K];
        for (int i = 0; i < K; i++) {
            help[i] = queue.poll();
        }
        return help;
    }

}
