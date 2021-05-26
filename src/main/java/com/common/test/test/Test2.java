package com.common.test.test;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Aug
 * @Date: 2020-09-17 11:07
 * @Desc:
 */
@Slf4j
public class Test2 {


    public static void main(String[] args) {
//        BigDecimal b1 = new BigDecimal(0);
//        BigDecimal b2 = new BigDecimal(10);
//        System.out.println(b1.divide(b2,4, RoundingMode.DOWN));
//        System.out.println(b1.divide(b2,4, RoundingMode.DOWN).signum());

        Map<String,String> map = new HashMap<>();
        long t1 =System.currentTimeMillis()*1000;
        log.info("t1:{}",t1);
        map.put("1","1");
        map.get("1");
        long t2 = System.currentTimeMillis()*1000-t1;
        log.info("t2:{}",t2);

    }
}
