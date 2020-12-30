package com.leetcode.algorithm.chacpter2.demo2_removeDuplicates.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2020-12-22 19:51
 * @Desc:
 */
@Slf4j
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 8, 8};
        int len = removeDuplicates(nums);
        log.info("nums len:{}", len);
        log.info("nums:{}", nums);
    }

    private static int removeDuplicates(int[] nums) {
        int i = 0;
        if (nums.length < 2) {
            return nums.length;
        }
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
