package com.pattern.demo12.composite.demo4;


import java.util.ArrayList;

/**
 * Desc:
 * Created by jinx on 2017/8/28.
 */
public class BranchImpl extends Corp {

    ArrayList<Corp> subordinate = new ArrayList();

    public BranchImpl(String name, String position, int salary) {
        super(name, position, salary);
    }

    public void addSubordinate(Corp corp) {
        //添加父节点
        corp.setParent(this);
        subordinate.add(corp);
    }

    public ArrayList<Corp> getSubordinate() {
        return this.subordinate;
    }
}
