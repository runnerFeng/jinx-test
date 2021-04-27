package com.pattern.demo16_state.demo3;

/**
 * Desc:
 * Created by jinx on 2017/8/31.
 */
public class ClosingState extends LiftState {
    @Override
    public void open() {
        super.context.setLiftState(Context.openingState);
        super.context.open();
    }

    @Override
    public void close() {
        System.out.println("电梯关闭了");
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.run();
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.stop();
    }
}
