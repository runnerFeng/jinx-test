package com.common.test.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: Aug
 * @Date: 2020-09-17 11:07
 * @Desc:
 */
public class Test2 {


    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal(0);
        BigDecimal b2 = new BigDecimal(10);
        System.out.println(b1.divide(b2,4, RoundingMode.DOWN));
        System.out.println(b1.divide(b2,4, RoundingMode.DOWN).signum());

    }
}
