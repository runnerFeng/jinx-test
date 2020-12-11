package com.leetcode.algorithm.chacpter2.demo1_minSubArraryLen.method2;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2020-12-09 19:59
 * @Desc: 最小子数组长度
 */
@Slf4j
public class MinSubArrayLen {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums = {1, 3, 5, 2, 7, 2};
        int target = 1;
        int result = minSubArrayLen(nums, target);
        long end = System.currentTimeMillis();
        log.info("result:{},cost time:{}", result, end - start);
    }

    private static int minSubArrayLen(int[] nums, int target) {
        int minLen = 0;
        int j = 0;
        int sum = 0;
        while (){

        }
        return minLen;
    }
}
