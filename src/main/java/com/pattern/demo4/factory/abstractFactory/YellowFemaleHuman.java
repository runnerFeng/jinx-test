package com.pattern.demo4.factory.abstractFactory;

/**
 * Desc:
 * Created by jinx on 2017/8/9.
 */
public class YellowFemaleHuman extends AbstractYellowHuman {
    @Override
    public void sex() {
        System.out.println("该黄种人的性别为女！");
    }
}
