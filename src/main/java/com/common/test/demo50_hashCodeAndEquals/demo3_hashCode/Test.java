package com.common.test.demo50_hashCodeAndEquals.demo3_hashCode;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: fans
 * @Date: 2021/7/1 01:18
 * @Desc:
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        Person person1 = Person.builder().name("jinx").age(17).build();
        Person person2 = Person.builder().name("jinx").age(17).build();
        log.info("person1:{}",person1);
        log.info("person2:{}",person2);
        // 此时比较的是内存地址,即调用Object.equals方法，返回false,但是hashCode值相等
        // 2.如果保存到hash结构的集合中（hashSet(存入值相同的对象),hashMap(覆盖原来的对象)）不能保证数据的唯一性，故我们需重写hashCode方法
        log.info("person1.equals(person2):{}",person1.equals(person2));
        log.info("person1.hashCode:{}",person1.hashCode());
        log.info("person2.hashCode:{}",person2.hashCode());
    }

}
