package com.leetcode.algorithm.chacpter3.demo6_maxSlidingWindow.method1;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author: Aug
 * @Date: 2021-03-03 16:26
 * @Desc: 滑动窗口:暴力法在数组长度很大时会造成内存不足
 */
@Slf4j
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        log.info("result:{}", result);
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        // 子数组个数
        int arrCount = nums.length - k + 1;
        int[][] subArrays = new int[arrCount][k];
        // 取子数组的次数
        for (int i = 0; i < arrCount; i++) {
            int[] arr = subArrays[i];

            int start = 0;
            for (int j = i; j < i + k; j++) {
                arr[start] = nums[j];
                start++;
            }
        }

        int[] result = new int[arrCount];
        for (int i = 0; i < arrCount; i++) {
            int max = Arrays.stream(subArrays[i]).max().getAsInt();
            result[i] = max;
        }
        return result;
    }

}
