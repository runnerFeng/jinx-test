package com.common.test.demo20_map;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author jinx
 * @Date 2021/12/31
 * @Desc hashmap浅拷贝之后, 新容器调用remove方法是remove什么东西？会不会影响老容器中的数据
 *       answer:新容器remove的是自己的索引key和对应的value（value中保存的是Integer对象在内存中的地址），但是对于内存地址指向的堆中的
 *       Integer对象始终存在，而且此时旧容器中的某个key对应的value还是指向该Integer对象的
 */
@Slf4j
public class HashMapRemoveTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> currentMap = new HashMap<>();
        currentMap.put(1, 1);
        currentMap.put(2, 2);
        log.info("currentMap:{}",currentMap);

        Map<Integer, Integer> newMap = (HashMap<Integer, Integer>) currentMap.clone();
        log.info("newMap:{}",newMap);

        newMap.remove(1);
        log.info("updated currentMap:{}",currentMap);
        log.info("updated newMap:{}",newMap);

        log.info("current result size:{}",currentMap.size());
        log.info("new result:{}",newMap.size());
    }
}
