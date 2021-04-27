package com.pattern.demo10_command.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/26.
 */
public class PageGroup extends Group {
    @Override
    public void add() {
        System.out.println("客户要求新增一个页面");
    }

    @Override
    public void change() {
        System.out.println("客户要求修改一个页面");
    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一个页面");
    }

    @Override
    public void find() {
        System.out.println("找到美工组");
    }

    @Override
    public void plan() {
        System.out.println("客户要求页面变更计划");
    }
}
