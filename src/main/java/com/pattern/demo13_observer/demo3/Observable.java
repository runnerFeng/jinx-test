package com.pattern.demo13_observer.demo3;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public interface Observable {
    void addObserver(com.pattern.demo13_observer.demo3.Observer observer);

    void deleteObserver(com.pattern.demo13_observer.demo3.Observer observer);

    void notifyObservers(String context);
}
