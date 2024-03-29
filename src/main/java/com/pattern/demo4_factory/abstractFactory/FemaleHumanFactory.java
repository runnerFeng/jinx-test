package com.pattern.demo4_factory.abstractFactory;

/**
 * Desc:
 * Created by jinx on 2017/8/9.
 */
public class FemaleHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YellowFemaleHuman);
    }

    @Override
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BlackFemaleHuman);
    }

    @Override
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteFemaleHuman);
    }
}
