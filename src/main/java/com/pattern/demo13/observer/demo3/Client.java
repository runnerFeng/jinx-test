package com.pattern.demo13.observer.demo3;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public class Client {
    public static void main(String[] args) {
        //观察者
        Observer lisi = new LiSi();

        //被观察者
        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.addObserver(lisi);

        hanFeiZi.haveBreakfast();
        hanFeiZi.haveFun();
    }
}
