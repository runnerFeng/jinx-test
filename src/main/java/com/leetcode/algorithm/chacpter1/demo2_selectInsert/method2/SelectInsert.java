package com.leetcode.algorithm.chacpter1.demo2_selectInsert.method2;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2020-12-08 10:10
 * @Desc: 暴力破解
 */
@Slf4j
public class SelectInsert {
    public static void main(String[] args) {
        int[] nums = {1, 4, 7, 9};
        int result = selectInsert(nums, 18);
        log.info("result:{}", result);
    }

    private static int selectInsert(int[] nums, int t) {
        for (int i = 0; i < nums.length; i++) {
            if (t <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}
