package com.imooc.pattern.demo1_singleton;

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
        System.out.println(s1 == s2);

        Singleton2 s3 = Singleton2.getInstance();
        Singleton2 s4 = Singleton2.getInstance();
        System.out.println(s3 == s4);
    }
}
