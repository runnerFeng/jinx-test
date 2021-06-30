package com.common.test.demo50_hashCodeAndEquals.demo4_equalsAndHashCode;

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
        // 此时比较的是属性值，返回true，hashCode值也相等
        // 2.如果保存到hash结构的集合中（hashSet,hashMap）能保证数据的唯一性
        log.info("person1.equals(person2):{}",person1.equals(person2));
        log.info("person1.hashCode:{}",person1.hashCode());
        log.info("person2.hashCode:{}",person2.hashCode());
    }

}
