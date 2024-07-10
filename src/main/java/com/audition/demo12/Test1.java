package com.audition.demo12;

/**
 * @Author jinx
 * @Date 2023/10/10
 * @Desc
 */
public class Test1 {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        oper(a, b);
        System.out.println(a + "." + b);
    }

    private static void oper(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
        System.out.println(x);
        System.out.println(y);
    }
}
