package com.common.test.demo40_abstractClass;

/**
 * @Author: Aug
 * @Date: 2021-03-08 10:37
 * @Desc:
 */
public class ClassA extends BaseClass {

    @Override
    void method2() {
        System.out.println("i am a general class because i have implement abstract method in baseClass");
    }

    // abstract class can not be instantiated
//    BaseClass baseClass = new BaseClass();
}
