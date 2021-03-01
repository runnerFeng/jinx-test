package com.leetcode.algorithm.chacpter8.demo6_diagonalSort.method1;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

/**
 * @Author: Aug
 * @Date: 2021-03-01 16:08
 * @Desc: todo
 */
@Slf4j
public class DiagonalSort {

    public static void main(String[] args) {
        int[][] mat = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        int[][] result = diagonalSort(mat);
        log.info("result:{}",result);
    }

    private static int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length, lineCount = m + n - 1;

        PriorityQueue<Integer>[] queues = new PriorityQueue[lineCount];
        // 行
        for (int i = 0; i < m; i++) {
            // 列
            for (int j = 0; j < n; j++) {
                if (queues[j - i + m - 1] == null) {
                    queues[j - i + m - 1] = new PriorityQueue();
                }
                queues[j - i + m - 1].offer(mat[i][j]);
            }
        }
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = j - i + m - 1;
                result[i][j] = queues[index].poll();
            }
        }

        return result;
    }

}
