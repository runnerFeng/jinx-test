package com.common.test.demo31_annotation.demo1;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jinx
 * @date 2018/9/13 11:22
 * Desc:
 */
@Component
public class TrimAnnotationFormatterFactory implements AnnotationFormatterFactory<Trim> {

    @Resource
    private TrimFormatter formatter;

    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> fieldTypes = new HashSet<>(1, 1);
        fieldTypes.add(String.class);
        return fieldTypes;
    }

    @Override
    public Parser<?> getParser(Trim annotation, Class<?> fieldType) {
        return formatter;
    }

    @Override
    public Printer<?> getPrinter(Trim annotation, Class<?> fieldType) {
        return formatter;
    }
}
