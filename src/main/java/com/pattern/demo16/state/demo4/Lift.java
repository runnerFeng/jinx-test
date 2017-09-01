package com.pattern.demo16.state.demo4;

/**
 * Desc:
 * Created by jinx on 2017/9/1.
 */
public class Lift {
    private LiftState state;

    public LiftState getState() {
        return state;
    }

    public void setState(LiftState state) {
        this.state = state;
    }

    public void open() {
        this.getState().open(this);
    }

    public void close() {
        this.getState().close(this);
    }

    public void run() {
        this.getState().run(this);
    }

    public void stop() {
        this.getState().stop(this);
    }
}
