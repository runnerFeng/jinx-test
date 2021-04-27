package com.pattern.demo4_factory.abstractFactory;

/**
 * Desc:
 * Created by jinx on 2017/8/9.
 */
public abstract class AbstractBlackHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("黑色人笑");
    }

    @Override
    public void cry() {
        System.out.println("黑色人哭");

    }

    @Override
    public void talk() {
        System.out.println("黑色人讨论");

    }
}
