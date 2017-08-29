package com.pattern.demo14.chainOfResponsibility.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public class Husband extends Hander {

    public Husband() {
        super(2);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("妻子向丈夫请示");
        System.out.println(women.getRequest());
        System.out.println("丈夫的答复是同意");
    }
}
