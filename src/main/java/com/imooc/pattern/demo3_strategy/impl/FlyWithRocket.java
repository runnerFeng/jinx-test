package com.imooc.pattern.demo3_strategy.impl;

import com.imooc.pattern.demo3_strategy.FlyingStrategy;

/**
 * Desc:
 * Created by jinx on 2017/4/8.
 */
public class FlyWithRocket implements FlyingStrategy{

    public void performFly() {
        System.out.println("用火箭遨游太空");
    }
}
