package com.pattern.demo20.Flyweight.demo2;

/**
 * Desc:
 * Created by jinx on 2017/9/7.
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "刘";
        String s2 = "锋";
        System.out.println((s1 + s2).intern());
    }
}
