package com.leetcode.algorithm.chacpter2.demo1_minSubArraryLen.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2020-12-08 19:31
 * @Desc:最小子数组长度：暴力法
 * 执行结果：通过
 * 执行用时：145 ms, 在所有 Java 提交中击败了14.96%的用户
 * 内存消耗：38.3 MB, 在所有 Java 提交中击败了88.14%的用户
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
        // 控制左边界
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            // 控制右边界
            for (int j = i; j < nums.length; j++) {
                int element = nums[j];
                sum += element;
                if (sum >= target) {
                    int newMinLen = j - i + 1;
                    // 第一次循环minLen=0直接赋值，后续循环需要进行比较才能赋值
                    if (minLen == 0 || newMinLen < minLen) {
                        minLen = newMinLen;
                    }
                    break;
                }
            }
        }
        return minLen;
    }
}
