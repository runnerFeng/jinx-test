package com.pattern.demo9.bridge.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/15.
 */
public class HouseCorp extends Corp {
    @Override
    protected void produce() {
        System.out.println("房地产公司盖房子！");
    }

    @Override
    protected void sell() {
        System.out.println("房地产公司卖房子！");
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚大钱了！");
    }
}
