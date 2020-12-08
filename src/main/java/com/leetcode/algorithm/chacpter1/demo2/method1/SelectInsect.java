package com.leetcode.algorithm.chacpter1.demo2.method1;

/**
 * @Author: Aug
 * @Date: 2020-08-17 21:24
 * @Desc:搜索插入位置:二分法
 * 时间复杂度：O(logN)
 */
public class SelectInsect {

    public static void main(String[] args) {
        int[] nums = {1, 6, 9, 12};
        int target = 13;
        int index = selectInsert(nums, target);
        System.out.println(index);
    }

    private static int selectInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return start;
    }

}
