package com.commonTest.demo6_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Desc:
 * Created by jinx on 2017/3/1.
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List src1 = new ArrayList();
        src1.add("1");
        src1.add("2");
        src1.add("3");
        List dest = new ArrayList(src1);
        System.out.println(dest.size());
        //浅拷贝
        Collections.copy(dest,src1);

    }
}
