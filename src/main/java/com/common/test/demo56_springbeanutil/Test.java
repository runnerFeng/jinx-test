package com.common.test.demo56_springbeanutil;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author：summer
 * @Date：2023/5/16 17:11
 * @Desc：
 */
public class Test {
    public static void main(String[] args) {

        Man man = new Man();
        man.setName(null);
        man.setAge(44);
        Human human = new Human();
        human.setLeg("left leg");
        human.setFoot(null);
        human.setMan(man);
        TargetHuman target = new TargetHuman();
//        BeanUtils.copyProperties(human, target);
//        System.out.println(target);
//        BeanUtils.copyProperties(human, target, getNullPropertyNames(human));
//        System.out.println(target);

        MyBeanUtils.copyProperties(human,target);
        System.out.println(target);
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }



}
