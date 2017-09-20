package com.pattern.demo13.observer.demo4;

import java.util.Observer;

/**
 * Desc:1.观察者模式其实也可以形成一条观察链，根据经验建议，在一个观察者模式中最多出现一个对象既是观察者也是被观察者，也就是说消息最多转发一次（传递两次）
 *      2.观察者模式是广播的方式发出消息（1:N），责任链模式以链的方式传递消息(1:1)
 * Created by jinx on 2017/8/29.
 */
public class Client {
    public static void main(String[] args) {
        Observer lisi = new LiSi();
        Observer wangsi = new WangSi();
        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.addObserver(lisi);
        hanFeiZi.addObserver(wangsi);

        hanFeiZi.haveBreakfast();
        hanFeiZi.haveFun();
    }
}
