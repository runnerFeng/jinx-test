package com.common.test.demo7_string;

import org.apache.commons.lang3.StringUtils;

/**
 * @author jinx
 * @date 2018/4/8 15:38
 * Desc:
 */
public class StringTest2 {
    public static void main(String[] args) {

        String s = "1,2,3,";
        System.out.println(s.trim());
        System.out.println(StringUtils.trim(","));
        System.out.println(StringUtils.trimToEmpty(","));
        System.out.println(StringUtils.trimToNull(","));
        System.out.println(StringUtils.stripEnd(s, ","));
        System.out.println("--------------");
        System.out.println(StringUtils.right(s, s.length() - 1));
        System.out.println(StringUtils.substringAfterLast(s, ","));
        System.out.println(StringUtils.substringBeforeLast(s, ","));

    }
}
