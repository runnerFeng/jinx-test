package com.pattern.demo9.bridge.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/24.
 */
public class Clothes extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出的衣服是这个样子");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的衣服卖出去了");
    }
}
