package com.pattern.demo4_factory.simpleFactory;

/**
 * Desc:
 * Created by jinx on 2017/8/7.
 */
public class BlackHuman implements Human {

    @Override
    public void laugh() {
        System.out.println("黑种人大笑！");
    }

    @Override
    public void cry() {
        System.out.println("黑种人会哭！");
    }

    @Override
    public void talk() {
        System.out.println("黑种人交流！");
    }
}