package com.imooc.pattern.demo3_strategy;

import com.imooc.pattern.demo3_strategy.impl.FlyWithWin;

/**
 * Desc:
 * Created by jinx on 2017/4/7.
 */
public class MallarDuck extends Duck {

    public MallarDuck() {
        super();
        super.setFlyingStrategy(new FlyWithWin());
    }

    @Override
    public void display() {
        System.out.println("我的脖子是绿色的");
    }
}
