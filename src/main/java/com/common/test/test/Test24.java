package com.common.test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: lzp
 * @description:
 * @Date: 2022/5/23
 */
public class Test24 {

    public static void main(String[] args) {
        // 需要排序的字符串
        String arr[] = {"D12", "D12A", "B", "CX", "B1", "D12B", "C90B", "C100A", "B0", "C90A"};

        List<String> strList = Arrays.asList(arr);
        System.out.println(strList);

        Collections.sort(strList, (str1, str2) -> {
            int max = str1.length() > str2.length() ? str1.length() : str2.length();
            // 处理数据为null的情况
            if (str1 == null && str2 == null) {
                return 0;
            }
            if (str1 == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            // 比较字符串中的每个字符
            char c1;
            char c2;

            // 逐字比较返回结果
            for (int i = 0; i < max; i++) {
                c1 = str1.charAt(i);
                try {
                    c2 = str2.charAt(i);
                } catch (StringIndexOutOfBoundsException e) {
                    return 1;
                }

                // 如果都是数字的话，则需要考虑多位数的情况，取出完整的数字字符串，转化为数字再进行比较
                if (Character.isDigit(c1) && Character.isDigit(c2)) {
                    String numStr1 = "";
                    String numStr2 = "";
                    // 获取数字部分字符串
                    for (int j = i; j < str1.length(); j++) {
                        c1 = str1.charAt(j);
                        if (!Character.isDigit(c1)) { // 不是数字则直接退出循环
                            break;
                        }
                        numStr1 += c1;
                    }
                    for (int j = i; j < str2.length(); j++) {
                        c2 = str2.charAt(j);
                        if (!Character.isDigit(c2)) { // 考虑可能带小数的情况
                            break;
                        }
                        numStr2 += c2;
                    }

                    int value1 = Integer.parseInt(numStr1);
                    int value2 = Integer.parseInt(numStr2);
                    if (value1 > value2) {
                        return 1;
                    }
                    if (value1 < value2) {
                        return -1;
                    }
                }

                // 不是数字的比较方式
                if (c1 != c2) {
                    return c1 - c2;
                }

            }
            return 0;

        });
        System.out.println("排序后");
        System.out.println(strList);
    }


}
