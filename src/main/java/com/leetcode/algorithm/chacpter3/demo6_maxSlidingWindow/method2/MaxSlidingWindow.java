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
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] array = new int[]{1,3,6,2,9,0,12,4,7};
        int k = 4;

//        int[] nums = {1, -1};
//        int k = 1;
        int[] result = maxSlidingWindow(array, k);
        log.info("result:{}", result);
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        // 子数组个数
        int arrCount = nums.length != 0 ? nums.length - k + 1 : 0;
        int[] result = new int[arrCount];
        for (int i = 0; i < arrCount; i++) {
            int[] sub = Arrays.copyOfRange(nums, i, i + k);
            result[i] =getMax(sub);
        }
        return result;
    }

    private static int getMax(int[] nums){
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>result){
                result = nums[i];
            }
        }
        return result;
    }
}
