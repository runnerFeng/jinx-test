package com.common.test.demo22_reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jinx
 * @date 2018/2/27 15:32
 * Desc:getFields():获取所有public字段,包括父类字段;
 *      getDeclaredFields():获取所有字段,public和protected和private,但是不包括父类字段.
 */
public class Test {
    public static void main(String[] args) {
        Field[] fields0 = Model.class.getFields();
        for (Field field : fields0) {
            System.out.println(field.getName());
        }

        System.out.println("-----------------");

        Field[] fields = Model.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println("-------------");

        //获取子类父类所有字段
        List<Field> fieldList = new ArrayList<>();
        Class tempClass = Model.class;
        while (null != tempClass){
            fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass=tempClass.getSuperclass();
        }
        for (Field field : fieldList) {
            System.out.println(field.getName());
            if (field.getName().equals("privateField")){
                System.out.println("privateField exit!");
            }
        }
    }
}
