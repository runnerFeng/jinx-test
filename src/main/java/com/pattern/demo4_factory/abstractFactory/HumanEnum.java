package com.pattern.demo4_factory.abstractFactory;

/**
 * Desc:
 * Created by jinx on 2017/8/9.
 */
public enum HumanEnum {

    YellowMaleHuman("com.pattern.demo4_factory.abstractFactory.YellowMaleHuman"),
    YellowFemaleHuman("com.pattern.demo4_factory.abstractFactory.YellowFemaleHuman"),
    BlackMaleHuman("com.pattern.demo4_factory.abstractFactory.BlackMaleHuman"),
    BlackFemaleHuman("com.pattern.demo4_factory.abstractFactory.BlackFemaleHuman"),
    WhiteMaleHuman("com.pattern.demo4_factory.abstractFactory.WhiteMaleHuman"),
    WhiteFemaleHuman("com.pattern.demo4_factory.abstractFactory.WhiteFemaleHuman");

    private String value = "";

    HumanEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
