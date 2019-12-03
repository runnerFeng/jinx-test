package com.javaGuide.java.basic.demo1;

/**
 * @Author: fans
 * @Date: 2019-12-03 20:14
 * @Desc:继承
 */
public class Test2 extends Test1 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        // 访问父类公有属性,但不能访问私有属性
        System.out.println(test2.value);
    }
}
