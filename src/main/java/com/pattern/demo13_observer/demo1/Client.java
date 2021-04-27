package com.pattern.demo13_observer.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        LiSi liSi = new LiSi();
        HanFeiZi hanFeiZi = new HanFeiZi();


        Watch watchBreakfast = new Watch(hanFeiZi, liSi, "breakfast");
        Thread.sleep(1000);
        hanFeiZi.haveBreakfast();
        watchBreakfast.start();

        Watch watchFun = new Watch(hanFeiZi, liSi, "fun");
        Thread.sleep(1000);
        hanFeiZi.haveFun();
        watchFun.start();
    }
}
