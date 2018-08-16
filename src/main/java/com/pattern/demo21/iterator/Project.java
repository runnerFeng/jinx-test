package com.pattern.demo21.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jinx
 * @date 2018/08/06 21:32
 * Desc:
 */
public class Project implements IProject {
    private List<IProject> projectList = new ArrayList<>();

    private String name;
    private int num ;
    private int cost;

    public Project() {
    }

    public Project(String name, int num, int cost) {
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    @Override
    public void add(String name, int num, int cost) {
        projectList.add(new Project(name,num,cost));
    }

    @Override
    public String getProjectInfo() {
        String info = "";
        info = info+"项目名称是："+this.name;
        info = info+"项目人数是："+this.num;
        info = info+"项目花费是："+this.cost;
        return info;
    }

    @Override
    public IProjectIterator iterator() {
        return new ProjectIterator(this.projectList);
    }
}
