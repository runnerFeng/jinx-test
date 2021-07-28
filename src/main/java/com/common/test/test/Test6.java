package com.common.test.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-07-27 16:32
 * @Desc:
 */
@Slf4j
public class Test6 {

    public static void main(String[] args) {
        int[] array = {8, 4, 2, 3};
        // bubble sort
//        bubbleSort(array);
        // insert sort
//        insertSort(array);
        // fast sort
        fastSort(array);
        log.info("array:{}", array);
    }

    private static void fastSort(int[] array) {
        fastSort(array, 0, array.length-1);
    }

    private static void fastSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int i, j, index;
        i = left;
        j = right;
        index = array[i];
        while (i < j) {
            while (i < j && array[j] >= index) {
                j--;
            }
            if (i < j) {
                array[i++] = array[j];
            }
            while (i < j && array[i] < index) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }
        array[i] = index;
        fastSort(array,left,i-1);
        fastSort(array,i+1,right);
    }

    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
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
