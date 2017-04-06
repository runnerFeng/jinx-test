package com.imooc.demo3_strategy.impl;

import com.imooc.demo3_strategy.FlyingStrategy;

/**
 * Desc:
 * Created by jinx on 2017/4/7.
 */
public class FlyNoWay implements FlyingStrategy {
    public void performFly() {
        System.out.println("我不会飞行");
    }
}
