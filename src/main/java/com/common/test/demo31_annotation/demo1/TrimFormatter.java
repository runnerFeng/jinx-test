package com.common.test.demo31_annotation.demo1;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * @author jinx
 * @date 2018/9/13 16:38
 * Desc:
 */
@Component
public class TrimFormatter implements Formatter<String> {
    private static final Pattern PATTERN_WHITESPACES = Pattern.compile("\\s+");

    @Override
    public String print(String object, Locale locale) {
        return object;
    }

    @Override
    public String parse(String text, Locale locale) {
        return PATTERN_WHITESPACES.matcher(text.trim()).replaceAll("");
    }

    public static void main(String[] args) {
        String s = PATTERN_WHITESPACES.matcher("j inx ").replaceAll("");
        System.out.println("----" + s + "----");
    }
}
