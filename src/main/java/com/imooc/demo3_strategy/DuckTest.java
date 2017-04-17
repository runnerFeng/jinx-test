package com.imooc.demo3_strategy;

/**
 * Desc:
 * Created by jinx on 2017/4/7.
 */
public class DuckTest {
    public static void main(String[] args) {
        Duck duck = null;
//        duck = new MallarDuck();
//        duck = new RedHeadDuck();
//        duck = new RubberDuck();
        duck = new BigYellow();
        duck.display();
        duck.quack();
        duck.fly();

    }
}
