package com.pattern.demo9_bridge.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/24.
 */
public class House extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出的房子是这个样子");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的房子卖出去了");
    }
}
