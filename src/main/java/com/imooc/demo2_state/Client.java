package com.imooc.demo2_state;

/**
 * Desc:
 * Created by jinx on 2017/3/6.
 */
public class Client {

    public static void main(String[] args) {

        State state = new ConcreteStateA();

        Context context = new Context();

        context.setState(state);

        context.request("test");

    }


}
