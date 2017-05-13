package com.imooc.pattern.demo1_singleton;

/**
 * Desc:饿汉模式
 * Created by lf on 2017/1/23
 */
public class Singleton {

    private Singleton(){}

    /**
     * 饿汉模式
     */
    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }
}
