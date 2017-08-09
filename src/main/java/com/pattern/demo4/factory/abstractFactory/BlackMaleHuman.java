package com.pattern.demo4.factory.abstractFactory;

/**
 * Desc:
 * Created by jinx on 2017/8/9.
 */
public class BlackMaleHuman extends AbstractBlackHuman {
    @Override
    public void sex() {
        System.out.println("该黑种人的性别为男！");
    }
}
