package com.pattern.demo9.bridge.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/15.
 */
public abstract class Corp {
    protected abstract void produce();

    protected abstract void sell();

    public void makeMoney() {
        this.produce();
        this.sell();
    }
}
