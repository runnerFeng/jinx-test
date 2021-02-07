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
        int[] nums = {1,  2,2,2,2, 3,4};
        log.info("nums.length:{},nums:{}", nums.length, nums);
        int result = removeDuplicates(nums);
        log.info("new nums.length:{},nums:{}", result, nums);
    }

    private static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

//    private static int r(int[] nums) {
//        int i = 0;
//        for (int n : nums) {
//            if (i < 2 || n > nums[i - 2]) {
//                nums[i++] = n;
//            }
//        }
//    }

}
