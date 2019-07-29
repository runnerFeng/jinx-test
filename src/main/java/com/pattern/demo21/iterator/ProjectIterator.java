package com.pattern.demo21.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jinx
 * @date 2018/08/06 21:41
 * Desc:
 */
public class ProjectIterator implements IProjectIterator {
    private List<IProject> iProjectList = new ArrayList<>();
    private int currentItem = 0;

    public ProjectIterator(List<IProject> iProjectList) {
        this.iProjectList = iProjectList;
    }


    @Override
    public boolean hasNext() {
        boolean b = true;
        if (this.currentItem >= iProjectList.size() || this.iProjectList.get(currentItem) == null) {
            b = false;
        }
        return b;
    }

    @Override
    public Object next() {
        return this.iProjectList.get(currentItem++);
    }

    @Override
    public void remove() {

    }
}
