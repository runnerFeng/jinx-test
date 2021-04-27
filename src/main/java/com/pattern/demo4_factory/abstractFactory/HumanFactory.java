package com.pattern.demo4_factory.abstractFactory;

/**
 * Desc:
 * Created by jinx on 2017/8/9.
 */
public interface HumanFactory {
    Human createYellowHuman();

    Human createBlackHuman();

    Human createWhiteHuman();
}
