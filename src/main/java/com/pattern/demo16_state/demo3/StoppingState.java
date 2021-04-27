package com.pattern.demo16_state.demo3;

/**
 * Desc:
 * Created by jinx on 2017/8/31.
 */
public class StoppingState extends LiftState {
    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止了");
    }
}
