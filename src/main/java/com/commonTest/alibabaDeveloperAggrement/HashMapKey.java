package com.commonTest.alibabaDeveloperAggrement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Desc:
 * Created by jinx on 2017/5/18.
 */
public class HashMapKey {
    public static void main(String[] args) {
        Map<User, String> map1 = new HashMap<User, String>();

        User u1 = new User("11");
        User u2 = new User("22");
        User u3 = new User("33");
        User u4 = new User("33");
        map1.put(u1, "1");
        map1.put(u2, "2");
        map1.put(u3, "3");
        map1.put(u4, "4");

        System.out.println(map1.toString());
        //如果不重写equals()和hashCode()方法此处取值为null
        System.out.println(map1.get(new User("11")));
        System.out.println(map1.get(new User("22")));
        System.out.println(map1.get(new User("33")));

        //对map的遍历请使用entrySet(),别使用keySet()
        Iterator iterator1 = map1.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator1.next();
            System.out.println(((User) entry.getKey()).getUserName());
            System.out.println(entry.getValue());
            System.out.println("***********************");
        }


    }
}
