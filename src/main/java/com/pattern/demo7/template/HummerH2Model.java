package com.pattern.demo7.template;

/**
 * Desc:
 * Created by jinx on 2017/8/11.
 */
public class HummerH2Model extends HummerModel {
    @Override
    protected void start() {
        System.out.println("H2型号启动");
    }

    @Override
    protected void alarm() {
        System.out.println("H2型号鸣笛");
    }

    @Override
    protected void engineBoom() {
        System.out.println("H2型号引擎声是这样的");
    }

    @Override
    protected void stop() {
        System.out.println("H2型号熄火");
    }

}
