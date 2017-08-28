package com.pattern.demo12.composite.demo1;

import java.util.ArrayList;

/**
 * Desc:
 * Created by jinx on 2017/8/28.
 */
public class BranchImpl implements Branch {
    private String name;
    private String position;
    private int salary;
    private ArrayList subordinate = new ArrayList();

    public BranchImpl(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        String info;
        info = "名称：" + this.name;
        info += "\t职位：" + this.position;
        info += "\t薪水：" + this.salary;
        return info;
    }

    @Override
    public void add(Branch branch) {
        subordinate.add(branch);
    }

    @Override
    public void add(Leaf leaf) {
        subordinate.add(leaf);
    }

    @Override
    public ArrayList getSubordinateInfo() {
        return this.subordinate;
    }
}
