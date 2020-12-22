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
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 6, 8, 8, 9};
        int len = removeDuplicates(nums);
        log.info("nums len:{}", len);
    }

    private static int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        if (nums.length < 2) {
            return nums.length;
        }
        while (i < nums.length) {
            if (nums[i] == nums[j]) {
                i++;
            } else {

            }
        }
        return 0;
    }
}
