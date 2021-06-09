package com.common.test.demo47_finalParameter;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: fans
 * @Date: 2021/6/10 02:06
 * @Desc:
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        Student student = new Student();
        student.setUsername("jinx");
        student.setAge(10);
        log.info("username:{},age:{},student:{}", student.getUsername(), student.getAge(),student.hashCode());
       change(student);
        log.info("username:{},age:{},student:{}", student.getUsername(), student.getAge(),student.hashCode());

    }

    private static void change( Student student) {
        student = new Student();
        student.setAge(11);
    }

}
