package com.pattern.demo16_state.demo3;

/**
 * Desc:
 * Created by jinx on 2017/8/31.
 */
public class OpeningState extends LiftState {
    @Override
    public void open() {
        System.out.println("电梯开门");
    }

    @Override
    public void close() {
        super.context.setLiftState(Context.closingState);
        super.context.getLiftState().close();
    }

    @Override
    public void run() {
        //do nothing
    }

    @Override
    public void stop() {
        //do nothing
    }
}
