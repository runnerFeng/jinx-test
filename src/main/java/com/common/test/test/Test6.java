package com.common.test.test;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;

/**
 * @Author: Aug
 * @Date: 2021-07-27 16:32
 * @Desc: 排序默写
 */
@Slf4j
public class Test6 {

    // lruCache
    private int capacity;
    private static LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        int[] array = {8, 4, 2, 3};
        // 1.bubble sort
//        bubbleSort(array);
        // 2.select sort
//        selectSort(array);
        // 3.insert sort
//        insertSort(array);
        // 4.shell sort
//        shellSort(array);
        // 5.fast sort
//        fastSort(array);
        // 6.bucket sort
        // 7. mergeSort(array)

        log.info("array:{}", array);
        // lruCache

        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        log.info("map.remove(){}",map.entrySet().iterator().next().getKey());

    }

    private static void bubbleSort(int[] array) {
        // 趟数
        for (int i = 0; i < array.length - 1; i++) {
            // 次数，j每次从0开始（每趟把排好序的元素放到最后边去）
            for (int j = 0; j < array.length - (i + 1); j++) {
                // 当前位置的元素和后一个位置的元素比较
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void selectSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            // 找到最小数的下标
            int minIndex = i;
            // 使用for中的第一个条件控制下一次的起始位置，即把排好序的元素放到了最左边（bubbleSort是把排好序的元素放到了最右边，并且是通过for中第二个条件控制循环停止位置）
            for (int j = i; j < array.length-1; j++) {
                if (array[minIndex]>array[j+1]){
                    minIndex = j+1;
                }
            }
            // 将最小数和未排序的数组首位交换
            if (minIndex!=i){
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    /**
     * 插入已经排好序的数组中
     *
     * @param array
     */
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

    private static void shellSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    private static void fastSort(int[] array) {
        fastSort(array, 0, array.length - 1);
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
        fastSort(array, left, i - 1);
        fastSort(array, i + 1, right);
    }

//    public int get(int key) {
//        if (!map.containsKey(key)) {
//            return -1;
//        }
//        makeRecently(key);
//        return map.get(key);
//    }
//
//    private void makeRecently(int key) {
//        int value = map.get(key);
//        map.remove(key);
//        map.put(key, value);
//    }
//
//    public void put(int key, int value) {
//        if (map.containsKey(key)) {
//            map.remove(key);
//        }
//        if (map.keySet().size() >= capacity) {
//            Integer oldKey = map.keySet().iterator().next();
//            map.remove(oldKey);
//        }
//        map.put(key, value);
//    }


}
