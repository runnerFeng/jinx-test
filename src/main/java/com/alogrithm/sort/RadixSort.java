package com.alogrithm.sort;

/**
 * @author jinx
 * @date 2019/2/18 9:47
 * Desc:基数排序:基本思想是将整数按位数切割成不同的数字，然后按每个位数分别比较。
 * 1.将所有待比较的数值统一为同样的位数长度，位数较短的数值前面补零。
 * 2.从最低位开始依次进行一次排序。这样从最低位排序一直到最高位排序完成后，数列就变成一个有序数列。
 * todo
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {9, 3, 4, 5, 10, 12, 5, 6};
        radixSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 获取最大值
     *
     * @param a
     * @return
     */
    public static int getMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    /**
     * 基数排序
     *
     * @param a
     */
    public static void radixSort(int[] a) {
        // 指数，当数组按个位排序时exp=1,按十位排序时exp=10...
        int exp;
        int max = getMax(a);
        for (exp = 1; max / exp > 0; exp *= 10) {
            countSort(a, exp);
        }
    }

    /**
     * 对数组某个位数进行排序(桶排序)
     *
     * @param a
     * @param exp
     */
    public static void countSort(int[] a, int exp) {
        int i, output[] = new int[a.length], buckets[] = new int[10];
        // 将数据出现的次数存储在buckets[]中
        for (i = 0; i < a.length; i++) {
            buckets[(a[i] / exp) % 10]++;
        }
        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }
        // 将数据存储到临时数组output[]中
        for (i = a.length - 1; i >= 0; i--) {
            output[buckets[(a[i] / exp) % 10] - 1] = a[i];
            buckets[(a[i] / exp) % 10]--;
        }
        // 将排序好的数据赋值给a[]
        for (i = 0; i < a.length; i++) {
            a[i] = output[i];
        }
    }

}
