package com.pattern.demo4.factory;

/**
 * Desc:
 * Created by jinx on 2017/8/7.
 */
public class WhiteHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("白种人大笑！");
    }

    @Override
    public void cry() {
        System.out.println("白种人会哭！");
    }

    @Override
    public void talk() {
        System.out.println("白种人交流！");
    }
}
