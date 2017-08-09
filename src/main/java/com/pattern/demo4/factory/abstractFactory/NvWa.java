package com.pattern.demo4.factory.abstractFactory;

/**
 * Desc:
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
