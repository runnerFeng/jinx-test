package com.common.test.demo41_singleton.method1;

import java.io.Serializable;

/**
 * @Author: Aug
 * @Date: 2021-03-11 10:54
 * @Desc: 基于volatile的双重检查锁定,但是这种方式在反序列化时也会通过反射重新破坏单例模式，可以通过重写readResolve（）方法来阻止这种破坏
 */
public class Singleton implements Serializable {

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

    private Object readResolve(){
        return instance;
    }


}
