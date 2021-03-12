package com.common.test.test;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Aug
 * @Date: 2021-03-08 17:01
 * @Desc:
 */
@Slf4j
public class Test3 {

    public static void main(String[] args) {
//        List list = new ArrayList<>();
//        log.info("list.size():{}",list.size());
//        list.remove(0);
//        list.add(11);
//        log.info("list.size():{}",list.size());
//
//        List list1 = new LinkedList();
//
//        List synchronizedList = Collections.synchronizedList(list);
//        List synchronizedRandomAccessList = Collections.synchronizedList(list1);
//
//        List copyOnWriteArrayList = new CopyOnWriteArrayList<>();
//
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("key1", 1);
        hashMap.put("key2", 2);
        hashMap.put("key3", 3);
        hashMap.put("key4", 4);
        hashMap.put("key5", 5);
        hashMap.put("key6", 6);

        for (Map.Entry<String,Integer> entry: hashMap.entrySet()) {
            String key = entry.getKey();
            if(key.contains("3")){
                hashMap.remove(entry.getKey());
            }
            System.out.println("当前HashMap是"+hashMap+" 当前entry是"+entry);

        }
    }

}
