package com.pattern.demo4.factory.abstractFactory;

/**
 * Desc:1.抽象工厂模式
 *      2.产品类和工厂类都用：接口继承实现
 * Created by jinx on 2017/8/9.
 */
public class NvWa {
    public static void main(String[] args) {
        HumanFactory maleHumanFactory = new MaleHumanFactory();
        Human human = maleHumanFactory.createYellowHuman();
        human.cry();
        human.laugh();
        human.talk();
        HumanFactory femaleHumanFactory = new FemaleHumanFactory();
        Human human1 = femaleHumanFactory.createBlackHuman();
        human1.laugh();
        human1.cry();
    }
}
