package com.leetcode.algorithm.chacpter3.demo2_medianFinder.method1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-02-09 16:58
 * @Desc:
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(2);
        finder.addNum(5);
        finder.addNum(4);
        finder.addNum(3);
//        finder.addNum(1);
//        finder.addNum(6);

        double result = finder.findMedian();
        log.info("result:{}",result);
    }
}
