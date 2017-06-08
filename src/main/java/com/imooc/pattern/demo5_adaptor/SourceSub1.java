package com.imooc.pattern.demo5_adaptor;

/**
 * Desc:
 * Created by jinx on 2017/6/8.
 */
public class SourceSub1 extends Wrapper2 {
    @Override
    public void method1() {
        System.out.println("the sourceable interface`s first Sub1!");
    }
}
