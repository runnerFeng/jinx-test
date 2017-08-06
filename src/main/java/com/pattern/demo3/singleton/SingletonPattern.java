package com.pattern.demo3.singleton;

/**
 * Desc:经典单例模式
 * Created by jinx on 2017/8/6.
 */
public class SingletonPattern {

    private static final SingletonPattern SINGLETON_PATTERN = new SingletonPattern();

    //private修饰，限制住不能直接产生一个实例
    private SingletonPattern() {
    }

    public synchronized static SingletonPattern getInstance() {
        return SINGLETON_PATTERN;
    }
}
