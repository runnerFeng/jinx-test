package com.common.test.demo4_systemInfo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Desc:
 * Created by lf on 2017/2/23
 */
public class GetSystemTime {
    public static void main(String[] args) {

        Date date = new Date(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(date);
        String str = "abc.jpg";
        System.out.println(str.split("\\.").length);
        System.out.println(str.split("\\.")[0]);

        System.out.println(BigDecimal.valueOf(0.01));
    }
}
