package com.pattern.demo12.composite.demo1;

import java.util.ArrayList;

/**
 * Desc:
 * Created by jinx on 2017/8/28.
 */
public interface Root {
    String getInfo();

    void add(Branch branch);

    void add(Leaf leaf);

    ArrayList getSubordinateInfo();
}
