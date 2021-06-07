package com.common.test.demo46_Vertx.method1;

import io.vertx.core.AbstractVerticle;

/**
 * @Author: Aug
 * @Date: 2021-06-02 16:18
 * @Desc: 使用Launcher代替main启动
 */
public class Test2 extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.deployVerticle(new MyFirstVerticle());
    }
}
