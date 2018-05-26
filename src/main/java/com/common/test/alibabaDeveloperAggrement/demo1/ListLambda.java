package com.common.test.alibabaDeveloperAggrement.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Created by jinx on 2017/5/19.
 */
public class ListLambda {
    public static void main(String[] args) {
        //stream.foreach()
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.stream().forEach(s -> System.out.print(s));

        //stream.map()处理List并给另一个list赋值


    }
}
