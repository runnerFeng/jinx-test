package com.pattern.demo8.builder;

/**
 * Desc:产品类
 * Created by jinx on 2017/8/14.
 */
public class BMWModel extends CarModel {

    @Override
    protected void start() {
        System.out.println("宝马启动");
    }

    @Override
    protected void alarm() {
        System.out.println("宝马鸣笛");
    }

    @Override
    protected void engineBoom() {
        System.out.println("宝马引擎发出声音");
    }

    @Override
    protected void stop() {
        System.out.println("宝马熄火了");
    }
}
