package com.leetcode.algorithm.chacpter3.demo1_largestRectangleArea.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-02-08 16:17
 * @Desc: 暴力破解
 */
@Slf4j
public class LargestRectangleArea {

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        int maxArea = calculateMaxArea(nums);
        log.info("max area:{}", maxArea);
    }

    private static int calculateMaxArea(int[] nums) {
        int area = 0, length = nums.length;
        if (length == 0) {
            return area;
        }

        int height;
        for (int i = 0; i < length; i++) {
            height = nums[i];
            int left = i, right = i;

            while (left - 1 > 0 && nums[left - 1] >= height) {
                left--;
            }

            while (right + 1 < length && nums[right + 1] >= height) {
                right++;
            }

            int newArea = (right - left + 1) * height;
            area = Math.max(area, newArea);
        }
        return area;
    }

}
