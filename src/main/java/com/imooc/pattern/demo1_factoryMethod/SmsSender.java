package com.imooc.pattern.demo1_factoryMethod;

/**
 * Desc:
 * Created by jinx on 2017/6/6.
 */
public class SmsSender implements Sender {
    @Override
    public void sender() {
        System.out.println("this is smsSender!");
    }
}
