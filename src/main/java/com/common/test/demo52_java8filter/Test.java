package com.common.test.demo52_java8filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;

import java.util.List;
import java.util.stream.Stream;

/**
 * @Author jinx
 * @Date 2021/11/11
 * @Desc
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        List<Student> students = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            Student s = new Student(i + "name", i + 10);
            students.add(s);
        }

        String userName = "3";
        Integer age = 12;
        Stream<Student> studentStream = students.stream().filter(s -> s.getUserName().equals(userName));




    }
}
