package com.common.test.test;


import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Aug
 * @Date: 2021-06-16 11:20
 * @Desc: test LinkedHashMap orderly output
 */
@Slf4j
public class Test5 {

    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, String.valueOf(i * i));
        }

        for (String value : map.values()) {
            log.info("value:{}",value);
        }
    }

}
