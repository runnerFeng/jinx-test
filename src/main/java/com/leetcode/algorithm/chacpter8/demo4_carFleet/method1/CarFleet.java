package com.leetcode.algorithm.chacpter8.demo4_carFleet.method1;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Aug
 * @Date: 2021-02-26 14:10
 * @Desc: todo
 */
@Slf4j
public class CarFleet {

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3}, speed = {2, 4, 1, 1, 3};
//        int[] position = {0,3, 5, 8,10}, speed = {1,3,1,4,2};

        int result = carFleet(target, position, speed);
        log.info("result:{}", result);
    }

    private static int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        Car[] cars = new Car[length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], (target - position[i]) / speed[i]);
        }
        Arrays.sort(cars, Comparator.comparingInt(o -> o.position));
        int result = 0;
        for (int i = length - 1; i > 0; i--) {
            if (cars[i].time < cars[i - 1].time) {
                result++;
            } else {
                cars[i - 1] = cars[i];
            }
        }
        return result;
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
