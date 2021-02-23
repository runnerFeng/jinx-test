package com.leetcode.algorithm.chacpter3.demo4_trap.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-02-23 15:04
 * @Desc: 根据列求和
 */
@Slf4j
public class Trap {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = trap(height);
        log.info("result:{}", result);
    }

    private static int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            // 求当前列左边最大的列
            int left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > left) {
                    left = height[j];
                }
            }
            // 求当前列右边最大的列
            int right = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > right) {
                    right = height[j];
                }
            }
            // 求最大最小列中较小列
            int min = Math.min(left, right);
            // 如果较小列比当前列还大则会蓄水
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }
}