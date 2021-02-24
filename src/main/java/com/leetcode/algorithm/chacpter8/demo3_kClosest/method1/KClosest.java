package com.leetcode.algorithm.chacpter8.demo3_kClosest.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: fans
 * @Date: 2021/2/24 23:24
 * @Desc:
 */
@Slf4j
public class KClosest {

    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}}; int K = 1;
        int[][] result = kClosest(points,K);
        log.info("result:{}",result);
    }

    private static int[][] kClosest(int[][] points, int k) {

        return new int[0][];
    }

}
