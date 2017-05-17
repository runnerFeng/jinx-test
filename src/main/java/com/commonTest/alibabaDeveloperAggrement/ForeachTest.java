package com.commonTest.alibabaDeveloperAggrement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Desc:
 * Created by jinx on 2017/5/17.
 */
public class ForeachTest {
    public static void main(String[] args) {
        //foreach循环中不能对元素进行修改操作（倒数第二个可以修改），否则会报java.util.ConcurrentModificationException
        //@link http://blog.csdn.net/bimuyulaila/article/details/52088124
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        a.add("3");
        for (String s : a) {
//            if ("1".equals(s))
            if ("2".equals(s)) {
                a.remove(s);
            }
        }
        for (String s : a) {
            System.out.println(s);
        }

        System.out.println("--------------------------");

        //对元素进行修改请使用迭代器
        List<String> b = new ArrayList<String>();
        b.add("1");
        b.add("2");
        b.add("3");
        Iterator<String> iterator = b.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("1"))
                iterator.remove();
        }

        for (String s : b) {
            System.out.println(s);
        }
    }
}
