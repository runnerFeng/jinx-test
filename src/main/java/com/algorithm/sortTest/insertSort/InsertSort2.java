package com.algorithm.sortTest.insertSort;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-06-07 11:07
 * @Desc: 将一个待排序的数据插入到已经排好序的有序序列中，直到插完所有元素为止。
 */
@Slf4j
public class InsertSort2 {

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 2};
        insertSort(array);
        log.info("array :{}", array);
    }

    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            // 如果i从1开始且j=i-1,则第二个条件j>=0；如果j=i,则第二个条件为j>0,不能有等号（其实是大于等于步长，此处步长为1，希尔排序中是gap长度）
            // 当符合比较条件时将前面一个元素移动到后面的位置，直到中间所有元素移动完后最后将temp移动到最前面空出来的位置即可
            for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                array[j + 1] = array[j];
            }
            // 注意此处赋值给j+1是因为经过了一次for训话的--操作，所以要加回来,其本质还是数组中的第j个元素
            array[j + 1] = temp;
        }
    }
}
