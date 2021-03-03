package com.leetcode.algorithm.chacpter3.demo6_maxSlidingWindow.method2;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author: Aug
 * @Date: 2021-03-03 17:29
 * @Desc:
 */
@Slf4j
public class MaxSlidingWindow {

    public static void main(String[] args) {
        // int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        // int k = 3;

//        int[] nums = {};
//        int k = 0;

        int[] nums = {1};
        int k = 1;
        int[] result = maxSlidingWindow(nums, k);
        log.info("result:{}", result);
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        // 子数组个数
        int arrCount = nums.length  == 0 ? 0 : nums.length - k + 1;
        int[] result = new int[arrCount];
        for (int i = 0; i < arrCount; i++) {
            // 计算每个子数组中的最大值
            result[i] = Arrays.stream(Arrays.copyOfRange(nums, i, i + k)).max().getAsInt();
        }
        return result;
    }
}
