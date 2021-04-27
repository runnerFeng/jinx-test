package com.pattern.demo12_composite.demo4;

/**
 * Desc:
 * Created by jinx on 2017/8/28.
 */
public abstract class Corp {
    private String name;
    private String position;
    private int salary;
    private Corp parent;

    public Corp(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getInfo() {
        String info;
        info = "名称：" + this.name;
        info += "\t职位：" + this.position;
        info += "\t薪水：" + this.salary;
        return info;
    }

    public Corp getParent() {
        return parent;
    }

    public void setParent(Corp parent) {
        this.parent = parent;
    }
}
