package com.alogrithm.sort;

import java.util.Arrays;

/**
 * Desc:快速排序
 * <a href="http://blog.csdn.net/jianyuerensheng/article/details/51258374">文档参考</a>
 * Created by lf on 2017/2/7
 */
public class FastSort {
    public static void main(String[] args) {

        int a[] = {49, 38, 65, 97, 76, 13, 27, 49};

        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a, int low, int high) {
        int i, j, index;
        if (low > high) {


            return;
        }
        i = low;
        j = high;
        index = a[i];
        while (i < j) {
            while (i < j && a[j] >= index) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }

            while (i < j && a[i] < index) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
            a[i] = index;
            sort(a, low, i - 1);
            sort(a, i + 1, high);
        }
    }

    public static void quickSort(int a[]) {
        sort(a, 0, a.length - 1);
    }

}

