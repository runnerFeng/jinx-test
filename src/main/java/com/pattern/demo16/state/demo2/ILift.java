package com.pattern.demo16.state.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/31.
 */
public interface ILift {
    int OPENING_STATE = 1;
    int CLOSING_STATE = 2;
    int RUNNING_STATE = 3;
    int STOPPING_STATE = 4;

    void setState(int state);

    void open();

    void close();

    void run();

    void stop();

}
