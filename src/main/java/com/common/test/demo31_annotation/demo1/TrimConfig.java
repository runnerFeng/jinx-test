package com.common.test.demo31_annotation.demo1;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @author jinx
 * @date 2018/9/13 11:24
 * Desc:
 */
@Configuration
public class TrimConfig extends WebMvcConfigurerAdapter {

    @Resource
    private TrimAnnotationFormatterFactory factory;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldAnnotation(factory);
        super.addFormatters(registry);
    }
}
