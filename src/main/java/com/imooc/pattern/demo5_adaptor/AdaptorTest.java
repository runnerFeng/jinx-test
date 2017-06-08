package com.imooc.pattern.demo5_adaptor;

/**
 * Desc:类适配器
 * Created by jinx on 2017/6/8.
 */
public class AdaptorTest {
    public static void main(String[] args) {
        Targetable targetable = new Adaptor();
        targetable.method1();
        targetable.method2();
    }
}
