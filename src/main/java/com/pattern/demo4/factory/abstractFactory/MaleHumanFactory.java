package com.pattern.demo4.factory.abstractFactory;

/**
 * Desc:
 * Created by jinx on 2017/8/9.
 */
public class MaleHumanFactory extends AbstractHumanFactory {
    @Override
    public void createYellowHuman() {
        super.createHuman(HumanEnum.YellowFemaleHuman);
    }

    @Override
    public void createBlackHuman() {
        super.createHuman(HumanEnum.BlackMaleHuman);

    }

    @Override
    public void createWhiteHuman() {
        super.createHuman(HumanEnum.WhiteMaleHuman);

    }
}
