package com.imooc.pattern.demo3_strategy;

import com.imooc.pattern.demo3_strategy.impl.FlyWithRocket;

/**
 * Desc:
 * Created by jinx on 2017/4/8.
 */
public class SpaceDuck extends Duck {
    public SpaceDuck() {
        super();
        super.setFlyingStrategy(new FlyWithRocket());

    }

    @Override
    public void display() {
        System.out.println("我头戴宇航头盔");
    }

    public void quack() {
        System.out.println("我通过无线电与你通信");
    }

}

