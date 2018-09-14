package com.common.test.demo31_annotation;

import java.lang.annotation.*;

/**
 * @author jinx
 * @date 2018/9/13 9:46
 * Desc:清除字符串前后的空格
 */
@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Trimmed {
    TrimmedType value() default TrimmedType.ALL_WHITE_SPACE;
}
