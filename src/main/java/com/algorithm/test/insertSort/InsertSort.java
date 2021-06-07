package com.algorithm.test.insertSort;

/**
 * @Author: Aug
 * @Date: 2021-06-04 16:19
 * @Desc:
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 6, 1, 9};
        int[] result = insertSort(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] > array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }

}
