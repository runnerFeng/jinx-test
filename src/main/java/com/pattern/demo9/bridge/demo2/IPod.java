package com.pattern.demo9.bridge.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/24.
 */
public class IPod extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产的IPod是这个样子");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的IPod卖出去了");
    }
}
