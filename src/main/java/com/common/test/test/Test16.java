package com.common.test.test;

import java.util.UUID;

/**
 * @Author：summer
 * @Date：2023/3/6 15:08
 * @Desc：
 */
public class Test16 {
    public static void main(String[] args) {
//        DateTime dateTime = DateUtil.offsetHour(DateUtil.date(), 8);
//        String s = DateUtil.formatDateTime(dateTime);
//        System.out.println(s);
//        System.out.println(new BigDecimal("null"));
//        String s = "abc";
//        String substring = StringUtils.substring(s, 0, 1);
//        System.out.println(substring);
//        List<Integer> list = Arrays.asList(1, 2, 3);
////        System.out.println(list.contains(4));
//
//        for (Integer in : list) {
//            if (in == 2) {
//                continue;
//            }
//            System.out.println(in);
//        }
//        System.out.println("end");

        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }
}
