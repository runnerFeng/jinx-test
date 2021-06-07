package com.algorithm.sort;

/**
 * @author jinx
 * @date 2019/2/15 15:02
 * Desc:插入排序:<a href="https://zhuanlan.zhihu.com/p/52884590"></a>
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {9, 3, 4, 5, 10, 12, 5, 6};
        insertSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            // j>0:因为i从0开始所以j=i=0,arr[j]就是第一个元素,所以arr[j-1]不存在，故第一个元素不比较，所以是j>0而不是j>=0（对比希尔排序）
            // 步长为1（所以j--）
            int j;
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
