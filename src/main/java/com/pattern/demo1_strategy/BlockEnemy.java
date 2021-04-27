package com.pattern.demo1_strategy;

/**
 * Desc:
 * Created by jinx on 2017/8/5.
 */
public class BlockEnemy implements IStrategy {
    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵!");
    }
}
