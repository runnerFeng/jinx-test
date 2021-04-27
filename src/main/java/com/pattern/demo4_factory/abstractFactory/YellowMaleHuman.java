package com.pattern.demo4_factory.abstractFactory;

/**
 * Desc:
 * Created by jinx on 2017/8/9.
 */
public class YellowMaleHuman extends AbstractYellowHuman {
    @Override
    public void sex() {
        System.out.println("该黄种人的性别为男！");
    }
}
