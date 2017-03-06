package com.imooc.demo1_singleton;

/**
 * Desc:
 * Created by lf on 2017/1/24
 */
public class Test {
    public static void main(String[] args) {
//        Singleton s1 = new Singleton();
//        Singleton s2 = new Singleton();
//        System.out.println(s1 == s2);
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1== s2);
    }
}
