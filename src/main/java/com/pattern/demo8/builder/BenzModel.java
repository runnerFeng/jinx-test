package com.pattern.demo8.builder;

/**
 * Desc:产品类
 * Created by jinx on 2017/8/11.
 */
public class BenzModel extends CarModel {

    @Override
    protected void start() {
        System.out.println("奔驰车启动了");
    }

    @Override
    protected void alarm() {

        System.out.println("奔驰车鸣笛了");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奔驰车引擎发出这样的声音");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰车熄火");
    }
}
