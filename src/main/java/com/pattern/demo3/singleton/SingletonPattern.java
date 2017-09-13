package com.pattern.demo3.singleton;

/**
 * Desc:经典单例模式
 * Created by jinx on 2017/8/6.
 */
public class SingletonPattern {

    //此处final具体几个意思？要不要都行吗？
    private static final SingletonPattern SINGLETON_PATTERN = new SingletonPattern();

    //private修饰，限制外界不能直接产生一个实例
    private SingletonPattern() {
    }

    //添加synchronized关键字是防止多线程环境下的问题
    public synchronized static SingletonPattern getInstance() {
        return SINGLETON_PATTERN;
    }


}
