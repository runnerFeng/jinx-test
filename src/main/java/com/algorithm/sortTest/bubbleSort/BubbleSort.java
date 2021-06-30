package com.algorithm.sortTest.bubbleSort;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-06-07 14:01
 * @Desc: 每一趟找出一个最大的元素放到后面，然后再找次大的原素，每次比较的次数比上次少一次，因为上次的元素已经确定大小了。故：j<array.length-(i+1)
 */
@Slf4j
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {1, 3, 6, 2, 5, 8};
        bubbleSort(array);
        log.info("array :{}", array);
    }

    private static void bubbleSort(int[] array) {
        // 控制趟数
        for (int i = 0; i < array.length - 1; i++) {
            // 控制次数,和右边的元素比较
            for (int j = 0; j < array.length - (i + 1); j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
