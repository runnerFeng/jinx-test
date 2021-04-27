package com.pattern.demo14_chainOfResponsibility.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public class Son extends Hander {

    public Son() {
        super(3);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("母亲向儿子请示");
        System.out.println(women.getRequest());
        System.out.println("儿子的答复是同意");
    }
}
