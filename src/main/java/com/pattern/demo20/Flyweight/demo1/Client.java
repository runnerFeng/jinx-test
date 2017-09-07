package com.pattern.demo20.Flyweight.demo1;

/**
 * Desc:
 * Created by jinx on 2017/9/7.
 */
public class Client {
    public static void main(String[] args) {
        SignInfo signInfo = SignInfoFactory.getSignInfo();
        System.out.println(signInfo.getId());
    }
}
