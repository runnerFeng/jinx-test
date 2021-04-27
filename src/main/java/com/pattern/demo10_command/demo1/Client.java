package com.pattern.demo10_command.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/27.
 */
public class Client {
    public static void main(String[] args) {
        Group group = new RequirementGroup();
        group.find();
        group.add();
        group.plan();

        group = new PageGroup();
        group.find();
        group.add();
        group.plan();
    }
}
