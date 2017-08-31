package com.pattern.demo16.state.demo3;

/**
 * Desc:
 * Created by jinx on 2017/8/31.
 */
public abstract class LiftState {

    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();

    public abstract void close();

    public abstract void run();

    public abstract void stop();


}
