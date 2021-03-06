package com.common.test.test;

import com.common.test.demo23_util.JsonUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Desc:
 * Created by jinx on 2017/5/4.
 */
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar thisMonthStart = Calendar.getInstance();
//        todayStart.set(todayStart.get(Calendar.YEAR)+1, todayStart.get(Calendar.MONTH)+1, todayStart.get(Calendar.DATE)+1);
//        todayStart.set(todayStart.get(Calendar.YEAR), todayStart.get(Calendar.MONTH), todayStart.get(Calendar.DATE));
//        System.out.println(sdf.format(todayStart.getTime()));

//        todayStart.setTime(new Date());
//        todayStart.add(Calendar.YEAR,1);
//        System.out.println(todayStart.getTime().getTime());
//        System.out.println(new Date().getTime());
//        System.out.println(sdf.format(todayStart.getTime()));

//        todayStart.add(Calendar.MONTH, 0);
//        todayStart.set(Calendar.DAY_OF_MONTH,1);
//        System.out.println(sdf.format(todayStart.getTime()));

//        todayStart.set(todayStart.get(Calendar.YEAR), todayStart.get(Calendar.MONTH), todayStart.get(Calendar.DATE), 0, 0, 0);
        thisMonthStart.set(thisMonthStart.get(Calendar.YEAR), thisMonthStart.get(Calendar.MONTH), 1, 0, 0, 0);
        System.out.println(thisMonthStart.getTime());

        System.out.println("----------");
        List<User> userList = new ArrayList<>();
        userList.add(new User("jinx",10));
        userList.add(new User("lux",12));

        Map<Integer,List<User>> map = new HashMap<>();
        map.put(1,userList);

        System.out.println(JsonUtils.toJsonString(userList));
        userList.get(0).age=13;
        System.out.println(JsonUtils.toJsonString(userList));

        System.out.println(JsonUtils.toJsonString(map));

    }

    public static class User{
        public String name;
        public int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
