package com.imooc.pattern.demo3_builder;

/**
 * Desc:
 * Created by jinx on 2017/6/7.
 */
public class Test {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);

    }
}
