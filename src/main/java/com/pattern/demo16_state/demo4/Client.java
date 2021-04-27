package com.pattern.demo16_state.demo4;

/**
 * Desc:一种更简洁的实现方式
 * Created by jinx on 2017/9/1.
 */
public class Client {
    public static void main(String[] args) {
        Lift lift = new Lift();
        lift.setState(LiftSateEnum.RUNNING);
        lift.open();
        lift.close();
        lift.stop();
        lift.run();
    }
}
