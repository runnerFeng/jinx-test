package com.commonTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Desc:
 * Created by jinx on 2017/5/4.
 */
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Calendar todayStart = Calendar.getInstance();
//        todayStart.set(todayStart.get(Calendar.YEAR)+1, todayStart.get(Calendar.MONTH)+1, todayStart.get(Calendar.DATE)+1);
//        System.out.println(sdf.format(todayStart.getTime()));

//        todayStart.setTime(new Date());
//        todayStart.add(Calendar.YEAR,1);
//        System.out.println(todayStart.getTime().getTime());
//        System.out.println(new Date().getTime());
//        System.out.println(sdf.format(todayStart.getTime()));

        todayStart.setTime(new Date());
        todayStart.add(Calendar.DAY_OF_WEEK, 7);
        System.out.println(todayStart.getTime());
    }
}
