package com.pattern.demo2_proxy;

/**
 * Desc:1.代理模式主要使用了 Java 的多态，干活的是被代理类，代理类主要是
 * 接活，你让我干活，好，我交给幕后的类去干，你满意就成，那怎么知道被代理类能不能干呢？同根就成，
 * 大家知根知底，你能做啥，我能做啥都清楚的很，同一个接口呗
 * 2.接口实现
 * Created by jinx on 2017/8/5.
 */
public class XiMenQing {
    public static void main(String[] args) {
        WangPo wangPo = new WangPo();

        wangPo.makeEyesWihtMan();
        wangPo.happyWithMan();
    }
}
