package com.leetcode.algorithm.chacpter2.demo8_removeDuplicates.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-02-07 13:54
 * @Desc:
 */
@Slf4j
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4};
        log.info("nums.length:{},nums:{}", nums.length, nums);
        int result = removeDuplicates2(nums);
        log.info("new nums.length:{},nums:{}", result, nums);
    }

    private static int removeDuplicates2(int[] nums) {
        // 特殊情况
        if (nums.length <= 2) {
            return nums.length;
        }
        int i = 2;
        int length = nums.length;
        for (int j = 2; j < length; j++) {
            if (nums[j] > nums[i - 2]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

}
