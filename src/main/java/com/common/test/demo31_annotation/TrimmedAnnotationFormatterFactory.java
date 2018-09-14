package com.common.test.demo31_annotation;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.text.ParseException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author jinx
 * @date 2018/9/13 10:19
 * Desc:<link http://www.cnblogs.com/EasonJim/p/7592352.html />
 */
public class TrimmedAnnotationFormatterFactory implements AnnotationFormatterFactory<Trimmed> {

    private static final Map<TrimmedType, TrimmerFormatter> TRIMMER_FORMATTER_MAP;

    static {
        TrimmedType[] values = TrimmedType.values();
        Map<TrimmedType, TrimmerFormatter> map = new HashMap<>(values.length);
        for (TrimmedType type : values) {
            map.put(type, new TrimmerFormatter(type));
        }
        TRIMMER_FORMATTER_MAP = Collections.unmodifiableMap(map);
    }

    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> fieldTypes = new HashSet<>(1, 1);
        fieldTypes.add(String.class);
        return fieldTypes;
    }

    @Override
    public Parser<?> getParser(Trimmed annotation, Class<?> fieldType) {
        return TRIMMER_FORMATTER_MAP.get(annotation.value());
    }

    @Override
    public Printer<?> getPrinter(Trimmed annotation, Class<?> fieldType) {
        return TRIMMER_FORMATTER_MAP.get(annotation.value());
    }

    private static class TrimmerFormatter implements Formatter<String> {

        private static final Pattern PATTERN_WHITESPACES = Pattern.compile("\\s+");
        private static final Pattern PATTERN_WHITESPACES_WITH_LINE_BREAK = Pattern.compile("\\s*\\n\\s*");
        private static final Pattern PATTERN_WHITESPACES_EXCEPT_LINE_BREAK = Pattern.compile("[\\s&&[^\\n]]+");

        private final TrimmedType type;

        public TrimmerFormatter(TrimmedType type) {
            if (type == null){
                throw new NullPointerException();}
            this.type = type;
        }

        @Override
        public String print(String object, Locale locale) {
            return object;
        }

        @Override
        public String parse(String text, Locale locale) throws ParseException {
            text = text.trim();
            switch (type) {
                case  ALL_WHITE_SPACE:
                    return PATTERN_WHITESPACES.matcher(text).replaceAll("");
                case EXCEPT_LINE_BREAK:
                    return PATTERN_WHITESPACES_EXCEPT_LINE_BREAK
                            .matcher(PATTERN_WHITESPACES_WITH_LINE_BREAK.matcher(text).replaceAll("\n")).replaceAll(" ");
                case SIMPLE:
                    return text;
                default:
                    // not possible
                    throw new AssertionError();
            }
        }

    }

    public static void main(String[] args) {
        String text = " j inx ";
         Pattern PATTERN_WHITESPACES = Pattern.compile("\\s+");
         String s = PATTERN_WHITESPACES.matcher(text).replaceAll("");
        System.out.println("----"+text+"----");
        System.out.println("----"+s+"----");
    }

}
