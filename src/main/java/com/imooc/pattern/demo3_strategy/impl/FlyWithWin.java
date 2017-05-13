package com.imooc.pattern.demo3_strategy.impl;

import com.imooc.pattern.demo3_strategy.FlyingStrategy;

/**
 * Desc:
 * Created by jinx on 2017/4/7.
 */
public class FlyWithWin implements FlyingStrategy {
    public void performFly() {
        System.out.println("振翅高飞");
    }
}
