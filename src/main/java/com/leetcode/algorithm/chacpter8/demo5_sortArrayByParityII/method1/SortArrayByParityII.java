package com.leetcode.algorithm.chacpter8.demo5_sortArrayByParityII.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-03-01 14:55
 * @Desc: 按奇偶排序数组 II
 */
@Slf4j
public class SortArrayByParityII {

    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 7};
        int[] result = sortArrayByParityII(nums);
        log.info("result:{}", result);
    }

    private static int[] sortArrayByParityII(int[] nums) {
        int[] help1 = new int[nums.length];
        int[] help2 = new int[nums.length];
        int k = 0;
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                help1[k] = nums[i];
                k=k+2;
            } else {
                help2[j] = nums[i];
                j=j+2;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = help1[i];
            } else {
                nums[i] = help2[i];
            }
        }

        return nums;
    }

}
