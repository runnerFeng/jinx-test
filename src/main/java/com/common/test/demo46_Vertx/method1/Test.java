package com.common.test.demo46_Vertx.method1;

import io.vertx.core.Vertx;

/**
 * @Author: Aug
 * @Date: 2021-06-02 15:56
 * @Desc: main方法启动方式
 */
public class Test {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MyFirstVerticle());
    }

}
