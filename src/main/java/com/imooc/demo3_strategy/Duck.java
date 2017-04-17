package com.imooc.demo3_strategy;

/**
 * Desc:显示和鸣叫
 * Created by jinx on 2017/4/7.
 */
public abstract class Duck {


    public void quack(){
        System.out.println("嘎嘎嘎");
    }

    public abstract void display();

    private FlyingStrategy flyingStrategy;

    public void fly(){
        flyingStrategy.performFly();
    }

    public void setFlyingStrategy(FlyingStrategy flyingStrategy) {
        this.flyingStrategy = flyingStrategy;
    }
}
