package com.pattern.demo10.command;

/**
 * Desc:
 * Created by jinx on 2017/8/24.
 */
public class RequirementGroup extends Group {
    @Override
    public void add() {
        System.out.println("客户要求新增一项需求");
    }

    @Override
    public void change() {
        System.out.println("客户要求改变一项需求");

    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一项需求");

    }

    @Override
    public void find() {
        System.out.println("招到需求组");

    }

    @Override
    public void plan() {
        System.out.println("客户要求需求变更计划");

    }
}
