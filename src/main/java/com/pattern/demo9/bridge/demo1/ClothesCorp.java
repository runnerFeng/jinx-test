package com.pattern.demo9.bridge.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/15.
 */
public class ClothesCorp extends Corp {
    @Override
    protected void produce() {
        System.out.println("服装公司生产衣服！");
    }

    @Override
    protected void sell() {
        System.out.println("服装公司销售衣服！");
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("服装公司赚小钱！");
    }
}
