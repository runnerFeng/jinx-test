package com.imooc.pattern.demo1_factoryMethod;

/**
 * Desc:
 * Created by jinx on 2017/6/6.
 */
public class SmsSenderFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
