package com.pattern.demo13_observer.demo4;


import java.util.Observable;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public class HanFeiZi extends Observable {

    public void haveBreakfast() {
        System.out.println("韩非子开始吃饭了");
        super.setChanged();
        super.notifyObservers("韩非子在吃饭");
    }

    public void haveFun() {
        System.out.println("韩非子开始娱乐了");
        super.setChanged();
        super.notifyObservers("韩非子在娱乐");
    }
}
