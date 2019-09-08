package com.common.test.demo0_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: jinx
 * @Date: 2019-09-07 12:51
 * @Desc:
 */
public class Test2 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Student("jinx"+i,i));
            if (i%4==0){
                list.add(new Student("jinx"+i,i+10));
            }
        }
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println("---------");

        Map<String,Student> map = list.stream().collect(Collectors.toMap(s->s.getUsername()+"-"+s.getAge(), s -> s));
        for (Map.Entry<String, Student> entry : map.entrySet()) {
            System.out.println(entry);
        }
        System.out.println(map.get("jinx0-0"));
    }
}
