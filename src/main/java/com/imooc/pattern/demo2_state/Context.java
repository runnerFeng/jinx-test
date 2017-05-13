package com.imooc.pattern.demo2_state;

/**
 * Desc:
 * Created by jinx on 2017/3/6.
 */
public class Context {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request(String sampleParameter){
        state.handle(sampleParameter);
    }

}
