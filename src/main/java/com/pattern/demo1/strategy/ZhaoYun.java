package com.pattern.demo1.strategy;

/**
 * Desc:
 * Created by jinx on 2017/8/5.
 */
public class ZhaoYun {
    public static void main(String[] args) {
        Context context;
        System.out.println("--------执行第一个锦囊执行--------------");
        context = new Context(new BackDoor());
        context.operate();
        System.out.println("--------执行第一个锦囊执行--------------");
        context = new Context(new GiveGreenLight());
        context.operate();
        System.out.println("--------执行第一个锦囊执行--------------");
        context = new Context(new BlockEnemy());
        context.operate();

    }
}
