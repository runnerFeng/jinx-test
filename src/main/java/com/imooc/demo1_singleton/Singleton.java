package com.imooc.demo1_singleton;

/**
 * Desc:
 * Created by lf on 2017/1/23
 */
public class Singleton {
        private Singleton(){
        }
    private static Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
}
