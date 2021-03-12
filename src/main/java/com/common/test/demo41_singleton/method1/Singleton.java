package com.common.test.demo41_singleton.method1;

/**
 * @Author: Aug
 * @Date: 2021-03-11 10:54
 * @Desc: 基于volatile的双重检查锁定
 */
public class Singleton {

    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
