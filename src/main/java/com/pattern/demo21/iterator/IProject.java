package com.pattern.demo21.iterator;

/**
 * @author jinx
 * @date 2018/08/06 21:29
 * Desc:
 */
public interface IProject {
    void add(String name, int num, int cost);

    String getProjectInfo();

    IProjectIterator iterator();
}
