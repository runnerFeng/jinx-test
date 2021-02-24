package com.leetcode.algorithm.chacpter8.demo2_wiggleSort.method1;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author: fans
 * @Date: 2021/2/24 22:32
 * @Desc: 排序->逆序穿插
 */
@Slf4j
public class WiggleSort {

    public static void main(String[] args) {
        int[] nums = {1,5,1,1,6,4};
        int[] nums1 = {1,2,2,4};
        nums1 = wiggleSort(nums1);
        log.info("nums:{}",nums1);
    }

    private static int[] wiggleSort(int[] nums) {
        int[] help = nums.clone();
        int length = nums.length;
        // 132,645->123,456->x6x5x4->362514
        Arrays.sort(help);
        for (int i = 1; i <nums.length ; i+=2) {
            nums[i] = help[--length];
        }
        for (int i = 0; i < nums.length; i+=2) {
            nums[i] = help[--length];
        }
        return nums;
    }

}
