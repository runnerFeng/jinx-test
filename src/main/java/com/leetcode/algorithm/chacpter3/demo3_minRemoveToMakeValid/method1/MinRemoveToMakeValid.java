package com.leetcode.algorithm.chacpter3.demo3_minRemoveToMakeValid.method1;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @Author: Aug
 * @Date: 2021-02-22 16:16
 * @Desc:
 */
@Slf4j
public class MinRemoveToMakeValid {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        String s1 = "l)ee(t(c)o)de)";
        String s2 = "))((";
        String result = minRemoveToMakeValid(s2);
        log.info("result:{}", result);
    }

    private static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] invalid = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                stack.push(i);
                invalid[i] = true;
            } else {
                if (')' == c && stack.empty()) {
                    invalid[i] = true;
                } else if (')' == c && !stack.empty()) {
                    invalid[stack.pop()] = false;
                }
            }
        }
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!invalid[i]) {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }
}
