package com.pattern.demo13.observer.demo4;

import java.util.Observer;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public class Client {
    public static void main(String[] args) {
        Observer lisi = new LiSi();

        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.addObserver(lisi);

        hanFeiZi.haveBreakfast();
        hanFeiZi.haveFun();
    }
}
