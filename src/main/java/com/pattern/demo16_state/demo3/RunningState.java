package com.pattern.demo16_state.demo3;

/**
 * Desc:
 * Created by jinx on 2017/8/31.
 */
public class RunningState extends LiftState {
    @Override
    public void open() {
    }

    @Override
    public void close() {
    }

    @Override
    public void run() {
        System.out.println("电梯运行了");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.stop();
    }
}
