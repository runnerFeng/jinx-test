package com.leetcode.algorithm.chacpter2.demo1_minSubArraryLen.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2020-12-08 19:31
 * @Desc:最小子数组长度
 */
@Slf4j
public class MinSubArrayLen {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums = {1, 3, 5, 2, 7, 2};
        int target = 7;
        int result = minSubArrayLen(nums, target);
        long end = System.currentTimeMillis();
        log.info("result:{},cost time:{}", result, end - start);
    }

    private static int minSubArrayLen(int[] nums, int target) {
        int result = 0;
//        int j = -1;
        int i = 0;
        int sum = 0;
//        if (nums[0]+nums[1])
        for (int j = -1; j < i; j++) {
            for (i = 0; i < nums.length; i++) {

            }
        }
        return result;
    }
}
