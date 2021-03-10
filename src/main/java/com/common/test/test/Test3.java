package com.common.test.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: Aug
 * @Date: 2021-03-08 17:01
 * @Desc:
 */
@Slf4j
public class Test3 {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        log.info("list.size():{}",list.size());
        list.remove(0);
        list.add(11);
        log.info("list.size():{}",list.size());

        List list1 = new LinkedList();

        List synchronizedList = Collections.synchronizedList(list);
        List synchronizedRandomAccessList = Collections.synchronizedList(list1);

        List copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    }

}
