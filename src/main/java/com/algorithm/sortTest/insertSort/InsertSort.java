package com.algorithm.sortTest.insertSort;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-06-04 16:19
 * @Desc:
 */
@Slf4j
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 6, 1, 9};
        insertSort(array);
        log.info("array:{}", array);
    }

    private static void insertSort(int[] array) {
        // 这种方式无效交换次数较多
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

}
