package com.imooc.pattern.demo1_singleton;

/**
 * Desc:懒汉模式
 * 区别：饿汉模式的特点是加载类时比较慢，但运行时获取对象的速度比较快，线程安全。
 * 懒汉模式反之。
 * Created by jinx on 2017/4/9.
 */
public class Singleton2 {

    private Singleton2() {
    }

    private static Singleton2 instance;

    /**
     * 懒汉模式
     *
     * @return
     */
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
