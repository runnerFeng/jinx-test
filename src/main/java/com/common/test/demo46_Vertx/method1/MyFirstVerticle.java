package com.common.test.demo46_Vertx.method1;

import io.vertx.core.AbstractVerticle;

/**
 * @Author: Aug
 * @Date: 2021-06-02 15:30
 * @Desc: @see https://vertxchina.github.io/vertx-translation-chinese/start/Start.html
 */
public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(req -> {
            req.response().putHeader("content-type", "text/plain").end("hello world!");
        }).listen(8088);
    }
}
