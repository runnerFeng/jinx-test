package com.imooc.demo3_strategy;

import com.imooc.demo3_strategy.impl.FlyNoWay;

/**
 * Desc:
 * Created by jinx on 2017/4/7.
 */
public class RubberDuck extends Duck {
    public RubberDuck() {
        super();
        super.setFlyingStrategy(new FlyNoWay());
    }

    @Override
    public void display() {
        System.out.println("我全身发黄，嘴巴很红");
    }


    public void quack() {
        System.out.println("嘎~嘎~嘎");
    }
}
