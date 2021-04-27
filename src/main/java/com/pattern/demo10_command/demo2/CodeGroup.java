package com.pattern.demo10_command.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/26.
 */
public class CodeGroup extends Group {
    @Override
    public void add() {
        System.out.println("客户要求新增一项功能");
    }

    @Override
    public void change() {
        System.out.println("客户要求修改一项功能");

    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一项功能");

    }

    @Override
    public void find() {
        System.out.println("找到代码组");

    }

    @Override
    public void plan() {
        System.out.println("客户要求代码变更计划");
    }
}
