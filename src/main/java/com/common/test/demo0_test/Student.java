package com.common.test.demo0_test;

import lombok.Data;

/**
 * @Author: jinx
 * @Date: 2019-09-08 12:06
 * @Desc:
 */
@Data
public class Student {
    private String username;
    private Integer age;

    public Student(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
