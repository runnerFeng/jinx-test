package com.pattern.demo1_strategy;

/**
 * Desc:
 * Created by jinx on 2017/8/5.
 */
public class BackDoor implements IStrategy {

    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力!");
    }
}
