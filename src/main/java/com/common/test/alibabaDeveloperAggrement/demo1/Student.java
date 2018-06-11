package com.common.test.alibabaDeveloperAggrement.demo1;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jinx
 * @date 2018/06/02 12:13
 * Desc:Set存储Object要重写hashcode方法
 */
@Data
public class Student {
    private Integer id;
    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Student student1 = new Student(1,"yi");
        Student student2 = new Student(1,"er");
        Student student3 = new Student(2,"san");
        Student student4 = new Student(2,"san");
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        studentSet.add(student4);
        for (Student student : studentSet) {
            System.out.println(student.getId()+"---"+student.getName());
        }

    }
}
