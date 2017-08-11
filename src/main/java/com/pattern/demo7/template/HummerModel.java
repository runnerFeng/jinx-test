package com.pattern.demo7.template;

/**
 * Desc:
 * Created by jinx on 2017/8/11.
 */
public abstract class HummerModel {

    //protected方法子类可以访问，同包下可以访问
    protected abstract void start();

    protected abstract void alarm();

    protected boolean isAlarm(){
        return true;
    };

    protected abstract void engineBoom();

    protected abstract void stop();


    final public void run() {
        this.start();
        if(this.isAlarm()){
            this.alarm();
        }
        this.engineBoom();
        this.stop();
    }
}
