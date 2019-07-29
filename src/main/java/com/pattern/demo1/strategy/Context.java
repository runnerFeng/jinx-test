package com.pattern.demo1.strategy;

/**
 * Desc:接口实现
 * Created by jinx on 2017/8/5.
 */
public class Context {

    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void operate() {
        strategy.operate();
    }

}
