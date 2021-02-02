package com.leetcode.algorithm.chacpter1.demo2_selectInsert.method1;

/**
 * @Author: Aug
 * @Date: 2020-08-17 21:24
 * @Desc:搜索插入位置:二分法
 * 时间复杂度：O(logN)
 */
public class SelectInsert {

    public static void main(String[] args) {
        int[] nums = {1, 6, 9, 12};
        int target = 3;
        int index = selectInsert(nums, target);
        System.out.println(index);
    }

    private static int selectInsert(int[] nums, int target) {
        // 先考虑起始值或者入参的特殊情况
        if (nums == null) {
            return 0;
        }
        // 再考虑正常流程
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

    private static int selectIn(int[] nums,int target){
        if (nums == null){
            return 0;
        }
        int start = 0,end = nums.length-1;
        while (start<=end){
            int middle = (start+end)/2;
            if (nums[middle] ==target){
                return middle;
            }if (nums[middle]<target){
                start = middle+1;
            }if (nums[middle]>target){
                end = middle-1;
            }
        }
        return start;
    }

}
