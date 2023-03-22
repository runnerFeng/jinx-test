package com.pattern.demo4_factory.abstractFactory;

/**
 * Desc:1.抽象工厂模式
 * 2.产品类和工厂类都用：接口继承实现
 * 3.网友理解：
 * 3.1.简单的说抽象工厂面对的问题更复杂。拿作者提出的产品等级结构和产品族来说，工厂方法没有产品族这个概念，有的只是产品等级。相当于工厂方法更适合一维的问题，抽象工厂面对的是多维的问题。这是我的理解。
 * 3.2.产品接口确定产品的等级结构，抽象工厂确定产品簇。这两个概念真的抽象的太好了！
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
