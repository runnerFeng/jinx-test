package com.common.test.demo50_hashCodeAndEquals.demo1_noHashCodeAndEquals;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: fans
 * @Date: 2021/7/1 01:17
 * @Desc: 注意lombok@Data注解会提供equals()、hashCode(),该测试中需要规避掉
 */
// @Data
@Builder
@Getter
@Setter
public class Person {
    private String name;
    private int age;
}
