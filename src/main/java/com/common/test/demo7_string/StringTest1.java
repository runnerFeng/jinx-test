package com.common.test.demo7_string;

/**
 * @author jinx
 * @date 2018/2/6 15:29
 * Desc:internal()：调用这个方法之后把字符串对象加入常量池中
 * 1.直接定义字符串变量的时候赋值，如果表达式右边只有字符串常量，那么就是把变量存放在常量池里面。
 * 2.new出来的字符串是存放在堆里面。
 * 3.对字符串进行拼接操作，也就是做"+"运算的时候，分2中情况：
 * i.表达式右边是纯字符串常量，那么存放在栈里面。
 * ii.表达式右边如果存在字符串引用，也就是字符串对象的句柄，那么就存放在堆里面。
 */
public class StringTest1 {
    public static void main(String[] args) {
        /*常量池中*/
        String s1 = "aaa";
        /*常量池中*/
        String s2 = "bbb";
        /*常量池中*/
        String s3 = "aaabbb";
        /*堆中*/
        String s4 = s1 + s2;
        /*栈中(常量池也在栈中)*/
        String s5 = "aaa" + "bbb";
        System.out.println(s3 == s4);
        System.out.println(s3 == s4.intern());
        System.out.println(s3 == s5);

        System.out.println("---------------------------");

        /*堆*/
        String s6 = new String("abc");
        /*常量池*/
        String s7 = "abc";
        /*堆*/
        String s8 = new String("abc");
        System.out.println(s6 == s7.intern());
        System.out.println(s6 == s8.intern());
        System.out.println(s7 == s8.intern());

        System.out.println("---------------------------");

        /*堆*/
        String s9 = new String("str")+new String("01");
        s9.intern();
        /*常量池*/
        String s10 = "str01";
        System.out.println(s9 == s10);

        System.out.println("----------------------------");

        /*堆*/
        String s11 = new String("str")+new String("01");
        /*常量池*/
        String s12 = "str01";
        s11.intern();
        System.out.println(s11 == s12);

    }

}
