package com.pattern.demo4_factory.abstractFactory;

/**
 * Desc:
 * Created by jinx on 2017/8/9.
 */
public class WhiteMaleHuman extends AbstractWhiteHuman {
    @Override
    public void sex() {
        System.out.println("该白种人的性别为男！");
    }
}
