package com.pattern.demo9.bridge.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/24.
 */
public class IPodCorp extends Corp {
    @Override
    protected void produce() {
        System.out.println("生产IPod");
    }

    @Override
    protected void sell() {
        System.out.println("IPod畅销");
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("我赚钱了");
    }
}
