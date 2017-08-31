package com.pattern.demo16.state.demo3;

/**
 * Desc:
 * Created by jinx on 2017/8/31.
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
//        context.setLiftState(new ClosingState());
        context.setLiftState(new RunningState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
