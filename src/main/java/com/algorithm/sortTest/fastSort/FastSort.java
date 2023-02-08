package com.algorithm.sortTest.fastSort;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-06-10 17:37
 * @Desc: <a href="https://blog.csdn.net/shujuelin/article/details/82423852"></a>
 */
@Slf4j
public class FastSort {

    public static void main(String[] args) {

        int[] a = {49, 38, 13, 27};
        log.info("a:{}", a);
        fastSort(a, 0, a.length - 1);
        log.info("a:{}", a);
    }

    private static void fastSort(int[] a, int start, int end) {
        if (start > end) {
            return;
        }
        int i = start;
        int j = end;
        // 此刻基准位a[i]是空的
        int baseTemp = a[start];
        // 一次遍历找出最终需要和base交换的位置
        while (i < j) {
            // 多次遍历找到i和j互换的位置，直到i=j终止
            while (a[j] >= baseTemp && i < j) {
                j--;
            }
            while (a[i] <= baseTemp && i < j) {
                i++;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        // 交换base和比较后的结果,此时i=j
        a[start] = a[i];
        a[i] = baseTemp;
        // 递归左边
        fastSort(a, start, i - 1);
        // 递归右边
        fastSort(a, i + 1, end);
    }

}
