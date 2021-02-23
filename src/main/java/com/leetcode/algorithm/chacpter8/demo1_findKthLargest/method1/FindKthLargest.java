package com.leetcode.algorithm.chacpter8.demo1_findKthLargest.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-02-23 17:11
 * @Desc: 手动排序
 */
@Slf4j
public class FindKthLargest {

    public static void main(String[] args) {
        int[] input = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = findKthLargest(input, k);
        log.info("result:{}", result);
    }

    private static int findKthLargest(int[] nums, int k) {
        // 排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        return nums[nums.length - k];
    }
}
