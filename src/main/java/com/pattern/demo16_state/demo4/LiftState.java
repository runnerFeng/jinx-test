package com.pattern.demo16_state.demo4;

/**
 * Desc:
 * Created by jinx on 2017/9/1.
 */
public interface LiftState {
    default void open(Lift lift) {
        throw new RuntimeException("error state");
    }

    default void close(Lift lift) {
        throw new RuntimeException("error state");
    }

    default void run(Lift lift) {
        throw new RuntimeException("error state");
    }

    default void stop(Lift lift) {
        throw new RuntimeException("error state");
    }
}
