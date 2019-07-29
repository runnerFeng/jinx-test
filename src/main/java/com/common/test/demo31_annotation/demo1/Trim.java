package com.common.test.demo31_annotation.demo1;

import java.lang.annotation.*;

/**
 * @author jinx
 * @date 2018/9/13 11:20
 * Desc:
 */
@Target(value = {ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Trim {
}
