package com.commonTest.alibabaDeveloperAggrement.demo1;

/**
 * Desc:equals NPE测试
 * Created by jinx on 2017/5/12.
 */
public class EqualsTest {

    public static void main(String[] args) {
        String a = null;
        if ("aa".equals(a))
//        if (a.equals("aa"))
        {
            System.out.println(true);
        }
        System.out.println(false);
    }
}
