package com.common.test.demo7_stringToDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Desc:
 * Created by lf on 2017/3/21
 */
public class StringToDateTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date = "2017-03-23";
        System.out.println(sdf.parse(date));


    }
}
