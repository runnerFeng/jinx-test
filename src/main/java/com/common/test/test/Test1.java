package com.common.test.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: Aug
 * @Date: 2020-09-08 22:31
 * @Desc:
 */
public class Test1 {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal(10);
        System.out.println(b.signum());
        System.out.println(b.precision());

        BigDecimal b1 = new BigDecimal(12);

        BigDecimal result = new BigDecimal(0).divide(b1,4, RoundingMode.DOWN);
        System.out.println(result);
        System.out.println(result.signum());
    }
}
