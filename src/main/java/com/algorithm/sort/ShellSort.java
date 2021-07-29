package com.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jinx
 * @date 2019/2/15 16:05
 * Desc:希尔排序:<a href="https://zhuanlan.zhihu.com/p/52884590"></a>
 */
@Slf4j
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {9, 3, 4, 5, 10, 12, 5, 6};
        shellSort(arr);
        log.info("arr:{}", arr);
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 此处i++即分组后只需移动1到下一组
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                // 相比于插入排序步长为1，此处步长为gap（所以j-=gap）
                for (j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
}
