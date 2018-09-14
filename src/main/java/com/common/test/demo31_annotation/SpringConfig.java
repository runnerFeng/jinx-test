package com.common.test.demo31_annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author jinx
 * @date 2018/9/13 10:27
 * Desc:TrimmedAnnotationFormatterFactory调用方法
 */
@Configuration
public class SpringConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldAnnotation(new TrimmedAnnotationFormatterFactory());
        super.addFormatters(registry);
    }
}
