package com.pattern.demo14_chainOfResponsibility.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public class Son implements IHandler {
    @Override
    public void handleMessage(IWomen women) {
        System.out.println("母亲的请示是：" + women.getRequest());
        System.out.println("儿子的答复是：同意");
    }
}
