package com.imooc.demo2_state;

/**
 * Desc:
 * Created by jinx on 2017/3/6.
 */
public class ConcreteStateA implements State {

    public void handle(String sampleParameter) {
        System.out.println("ConcreteStateA handle " + sampleParameter);
    }
}
