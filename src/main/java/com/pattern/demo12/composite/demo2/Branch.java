package com.pattern.demo12.composite.demo2;

import java.util.ArrayList;

/**
 * Desc:
 * Created by jinx on 2017/8/28.
 */
public interface Branch {
    void addSubordinate(Corp corp);

    ArrayList getSubordinate();
}
