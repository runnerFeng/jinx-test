package com.leetcode.algorithm.chacpter8.demo4_carFleet.method1;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Aug
 * @Date: 2021-02-26 14:10
 * @Desc: 车队
 */
@Slf4j
public class CarFleet {

    public static void main(String[] args) {
//        int target = 12;
//        int[] position = {10, 8, 0, 5, 3}, speed = {2, 4, 1, 1, 3};
//
        int target = 10;
        int[] position = {6, 8}, speed = {3, 2};

        int result = carFleet(target, position, speed);
        log.info("result:{}", result);
    }

    private static int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        Car[] cars = new Car[length];
        for (int i = 0; i < position.length; i++) {
            // Attention:注意此处必须转为double，否则类似3/2计算出来的时间会被取整为0造成误算
            cars[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);
        }

        Arrays.sort(cars, Comparator.comparingInt(o -> o.position));
        int result = 0;
        // cars升序，故从最后一辆车开始遍历
        for (int i = length - 1; i > 0; i--) {
            if (cars[i].time < cars[i - 1].time) {
                result++;
            } else {
                cars[i - 1] = cars[i];
            }
        }
        // NOTE:此处需要注意边界值cars[0],即：1.当cars[1].time-cars[0].time<0此时最后一辆车自成一队，但是程序已经不会再进入循环，
        // 没有加到result中；2.当cars[1]-cars[0]>=0此时进入else只是进行元素交换，result并未自加，所以两种情况都需加一。但是当position
        // 数组长度为0时则不用加1
        return result + (length == 0 ? 0 : 1);
    }

    static class Car {
        public int position;
        public double time;

        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }

}
