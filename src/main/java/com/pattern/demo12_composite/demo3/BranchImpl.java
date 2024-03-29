package com.pattern.demo12_composite.demo3;


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
        subordinate.add(corp);
    }

    public ArrayList<Corp> getSubordinate() {
        return this.subordinate;
    }
}
