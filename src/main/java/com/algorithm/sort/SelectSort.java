package com.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-08-09 14:20
 * @Desc: @see https://zzzgd.blog.csdn.net/article/details/87634775?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.control
 * Note:每一趟从未排序数组中找出一个最小的元素放到未排序数组首位
 */
@Slf4j
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {4, 8, 2, 19, 2, 93};
        selectSort(arr);
        log.info("arr:{}", arr);
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }

}
