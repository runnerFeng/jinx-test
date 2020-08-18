package com.javaGuide.java.basic.demo3;

/**
 * @Author: fans
 * @Date: 2019/12/3 23:35
 * @Desc:
 */
public class Test2 extends Test1 {
    private String gender;
    private Integer age;

    public Test2(String username, String password, String gender, Integer age) {
        super(username, password);
        this.gender = gender;
        this.age = age;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2("aug","123","man",29);
        System.out.println(test2.age);
    }
}
