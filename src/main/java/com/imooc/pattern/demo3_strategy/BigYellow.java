package com.imooc.pattern.demo3_strategy;

import com.imooc.pattern.demo3_strategy.impl.FlyNoWay;

/**
 * Desc:
 * Created by jinx on 2017/4/7.
 */
public class BigYellow extends Duck {
    public BigYellow() {
        super();
        super.setFlyingStrategy(new FlyNoWay());
    }


    public void display() {
        System.out.println("我身体很大，全身黄黄");
    }
}
