package com.alogrithm.sort;

/**
 * Desc:冒泡排序
 * Created by lf on 2017/2/7
 */
public class BubbleSort {
    public static void main(String[] args) {
        int score[] = {101, 69, 75, 87, 82, 90, 99, 100};
        bubbleSort(score);

        for (int a = 0; a < score.length; a++) {
            System.out.print(score[a] + "\t");
        }
    }

    public static void bubbleSort(int[] score) {
        // 控制趟数
        for (int i = 0; i < score.length - 1; i++) {
            // 控制次数，相比于插入排序该算法此处对比该位置右边的数
            for (int j = 0; j < score.length - (i + 1); j++) {
                if (score[j] > score[j + 1]) {
                    int temp = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = temp;
                }
            }
        }
    }
}
