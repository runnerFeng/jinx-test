package com.pattern.demo16.state.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/31.
 */
public interface ILift {
    int OPENING_STATE = 1;
    int CLOSING_STATE = 1;
    int RUNNING_STATE = 1;
    int STOPPING_STATE = 1;

    void setState();

    void open();

    void close();

    void run();

    void stop();

}
