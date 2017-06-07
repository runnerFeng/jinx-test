package com.imooc.pattern.demo2_singleton;

/**
 * Desc:
 * Created by jinx on 2017/6/7.
 */
public class Singleton {


    private Singleton() {
    }

    public static Singleton getInstance() {

        return SingletonFactory.instance;
    }

    public Object readResolve() {
        return getInstance();
    }

    private static class SingletonFactory {
        private static Singleton instance = new Singleton();

    }
}
