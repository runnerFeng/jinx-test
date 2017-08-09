package com.pattern.demo4.factory.simpleFactory;

/**
 * Desc:
 * Created by jinx on 2017/8/8.
 */
public class NvWa {
    public static void main(String[] args) {
        Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
        whiteHuman.cry();
        whiteHuman.laugh();
        whiteHuman.talk();
        Human blackHuman = HumanFactory.createHuman(BlackHuman.class);
        blackHuman.cry();
        blackHuman.laugh();
        blackHuman.talk();
        Human yellowHuman = HumanFactory.createHuman(YellowHuman.class);
        yellowHuman.cry();
        yellowHuman.laugh();
        yellowHuman.talk();

        for (int i = 0; i < 100; i++) {
            Human human = HumanFactory.createHuman();
            human.cry();
            human.laugh();
            human.talk();
        }

    }
}
