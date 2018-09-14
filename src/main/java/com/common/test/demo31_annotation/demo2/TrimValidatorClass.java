package com.common.test.demo31_annotation.demo2;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author jinx
 * @date 2018/9/13 18:45
 * Desc:
 */
public class TrimValidatorClass implements ConstraintValidator<TrimValidator,Object> {

    private String value;
    @Override
    public void initialize(TrimValidator constraintAnnotation) {
        this.value = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        boolean flag  = false;
        if (value.equals(flag)){
            return true;
        }
        return false;
    }
}
