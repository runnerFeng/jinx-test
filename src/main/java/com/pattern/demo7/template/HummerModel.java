package com.pattern.demo7.template;

/**
 * Desc:
 * Created by jinx on 2017/8/11.
 */
public abstract class HummerModel {

    //protected方法子类可以访问，同包下可以访问
    protected abstract void start();

    //基本方法
    protected abstract void alarm();

    protected abstract void engineBoom();

    protected abstract void stop();

    //钩子方法，抽象类来实现，子类可以重写，虽然客户端调用了同一个方法，但是因为不同的子类可能不同，所以执行结果可能不同（多态），典型的父类调用子类方法
    protected boolean isAlarm() {
        //默认为true
        return true;
    }

    //模板方法，final决定该方法执行顺序不能修改，但可以通过钩子方法变更内部执行顺序
    final public void run() {
        this.start();

        if (this.isAlarm()) {
            this.alarm();
        }
        this.engineBoom();
        this.stop();
    }
}
