package com.common.test.demo50_hashCodeAndEquals.demo3_hashCode;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        // 此处暂时用name长度值做为重写标的
        result = prime * result + (name == null?0:name.hashCode());
        return result;
    }
}
