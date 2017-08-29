package com.pattern.demo14.chainOfResponsibility.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public class Father extends Hander {

    public Father() {
        super(1);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("女儿向父亲请示");
        System.out.println(women.getRequest());
        System.out.println("父亲的答复是同意");
    }
}
