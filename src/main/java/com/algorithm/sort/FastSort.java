package com.algorithm.sort;

import java.util.Arrays;

/**
 * Desc:快速排序
 * <a href="http://blog.csdn.net/jianyuerensheng/article/details/51258374">文档参考</a>
 * <a href="https://blog.csdn.net/wehung/article/details/82704565?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-6.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-6.control">
 *     最佳解释</a>
 * Created by lf on 2017/2/7
 */
public class FastSort {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97};
        fastSort(a);
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
            // 注意这里有等号，下面一个比较没有等号
            while (i < j && a[j] >= index) {
                j--;
            }
            if (i < j) {
                // 注意这里a[i++]是两步，首先给a[i]赋值为a[j]，然后i++
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

    public static void fastSort(int[] a) {
        sort(a, 0, a.length - 1);
    }

}

