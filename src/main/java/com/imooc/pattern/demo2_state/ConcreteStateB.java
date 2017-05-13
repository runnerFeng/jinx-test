package com.imooc.pattern.demo2_state;

/**
 * Desc:
 * Created by jinx on 2017/3/6.
 */
public class ConcreteStateB implements State {

    public void handle(String sampleParameter) {
        System.out.println("ConcreteStateB handle" +sampleParameter);
    }
}
