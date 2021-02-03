package com.leetcode.algorithm.chacpter2.demo3_subArraySum.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-02-02 16:51
 * @Desc: 暴力破解法
 */
@Slf4j
public class SubArraySum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 7,-1, 2, 4, 5};
        int k = 6;
        int result = calculateAmount(nums, k);
        log.info("result:{}", result);
    }

    private static int calculateAmount(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                    // 此处注意不能用break跳出，如果紧接着的数是0，那么这也是一个解
//                    break;
                }
            }
        }
        return count;
    }
}
