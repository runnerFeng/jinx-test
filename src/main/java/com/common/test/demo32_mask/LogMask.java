package com.common.test.demo32_mask;

import java.lang.annotation.*;

/**
 * @author jinx
 * @date 2018/10/18 10:06
 * Desc:标注于controller方法的参数中，被标注的参数在进行日志输出会进行掩码处理
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.PARAMETER })
@Inherited
public @interface LogMask {
}
