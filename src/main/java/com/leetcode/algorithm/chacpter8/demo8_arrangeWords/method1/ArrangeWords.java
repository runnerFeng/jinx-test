package com.leetcode.algorithm.chacpter8.demo8_arrangeWords.method1;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author: Aug
 * @Date: 2021-03-02 10:41
 * @Desc: 重新排列句子中的单词
 */
@Slf4j
public class ArrangeWords {

    public static void main(String[] args) {
//        String text = "Leetcode is cool";
        String text = "Leetcode i cool";
        String result = arrangeWords(text);
        log.info("result:{}", result);
    }

    private static String arrangeWords(String text) {
        String[] strings = text.toLowerCase().split(" ");
        Arrays.sort(strings, (o1, o2) -> o1.length() - o2.length());
        String result = "";
        for (int i = 0; i < strings.length; i++) {
            result += strings[i].concat(" ");
        }
        return result.substring(0, 1).toUpperCase().concat(result.substring(1)).trim();
    }

}
