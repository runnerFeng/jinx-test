package com.pattern.demo16_state.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/31.
 */
public class Client {
    public static void main(String[] args) {
        ILift lift = new Lift();
        lift.open();
        lift.run();
        lift.stop();
        lift.close();
    }
}
