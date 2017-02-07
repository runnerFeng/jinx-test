package com.commonTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Desc:
 * Created by lf on 2017/2/7
 */
public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        List vector = new Vector();
        List linkList = new LinkedList();

        System.out.println(list.size());
    }
}
