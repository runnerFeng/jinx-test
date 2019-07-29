package com.common.test.demo31_annotation.demo2;

import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author jinx
 * @date 2018/9/13 18:40
 * Desc:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
public @interface TrimValidator {
    String values();

    // 提示内容
    String message() default "flag不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
