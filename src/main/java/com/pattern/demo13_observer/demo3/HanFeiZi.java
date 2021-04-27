package com.pattern.demo13_observer.demo3;

import java.util.ArrayList;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public class HanFeiZi implements Observable {

    private ArrayList<com.pattern.demo13_observer.demo3.Observer> observers = new ArrayList();

    @Override
    public void addObserver(com.pattern.demo13_observer.demo3.Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(com.pattern.demo13_observer.demo3.Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String context) {
        for (com.pattern.demo13_observer.demo3.Observer observer : observers) {
            observer.update(context);
        }
    }

    public void haveBreakfast() {
        System.out.println("韩非子：开始吃饭");
        this.notifyObservers("韩非子在吃饭");
    }

    public void haveFun() {
        System.out.println("韩非子:开始娱乐");
        this.notifyObservers("韩非子在娱乐");
    }

}
