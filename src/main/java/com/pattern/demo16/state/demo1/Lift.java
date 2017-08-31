package com.pattern.demo16.state.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/31.
 */
public class Lift implements ILift {
    @Override
    public void open() {
        System.out.println("电梯门开启");
    }

    @Override
    public void close() {
        System.out.println("电梯门关闭");
    }

    @Override
    public void run() {
        System.out.println("电梯上下跑");
    }

    @Override
    public void stop() {
        System.out.println("电梯停止");
    }
}
