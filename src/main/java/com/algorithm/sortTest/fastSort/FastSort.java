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

        int a[] = {49, 38, 13, 27};
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
        int base = a[i];
        // 一次遍历
        while (i < j) {
            while (a[j] >= base && i < j) {
                j--;
            }
            while (a[i] <= base && i < j) {
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
        a[i] = base;
//        base = a[end];
        fastSort(a, start, i - 1);
        fastSort(a, i + 1, end);
    }

}
