package com.pattern.demo16_state.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/31.
 */
public class Client {
    public static void main(String[] args) {
        ILift iLift = new Lift();
//        iLift.setState(ILift.STOPPING_STATE);
        iLift.setState(ILift.RUNNING_STATE);
        iLift.open();
        iLift.close();
        iLift.run();
        iLift.stop();
    }
}
