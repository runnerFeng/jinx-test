package com.common.test.test;

import java.util.Stack;

/**
 * @Author jinx
 * @Date 2023/10/26
 * @Desc 括号匹配:栈，先进后出
 */
public class Test19 {

    public static void main(String[] args) {
        String s1 = "({[)}]";
        String s2 = "({[]})";
        String s3 = "(){}[]";
        String s4 = "({[";
        String s5 = "{[]()}";
        System.out.println(validString(s1));
        System.out.println(validString(s2));
        System.out.println(validString(s3));
        System.out.println(validString(s4));
        System.out.println(validString(s5));
    }

    private static boolean validString(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (chars[i] == ')' && stack.pop() != '(') {
                    return false;
                }
                if (chars[i] == '}' && stack.pop() != '{') {
                    return false;
                }
                if (chars[i] == ']' && stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

//    public static boolean validString(String s) {
//        char[] chars = s.toCharArray();
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == '{' || chars[i] == '(' || chars[i] == '[') {
//                stack.push(chars[i]);
//            } else {
//                if (stack.isEmpty()) {
//                    return false;
//                }
//                if (chars[i] == '}' && stack.pop() != '{') {
//                    return false;
//                }
//
//            }
//
//        }
//        return stack.isEmpty();
//    }
}
