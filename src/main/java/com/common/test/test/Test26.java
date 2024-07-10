package com.common.test.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * @Author jinx
 * @Date 2023/11/8
 * @Desc 找到最长子串
 */
public class Test26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] lines = line.split("");
            // 长度是0
            if (lines.length == 0) {
                System.out.println(0);
                return;
            }
            // 长度是1
            if (lines.length == 1) {
                System.out.println(1);
                return;
            }
            // 特殊情况(假设都相等)
            boolean isSame = true;
            String str = lines[0];
            for (int i = 1; i < lines.length; i++) {
                if (!lines[i].equals(str)) {
                    isSame = false;
                }
            }
            if (isSame) {
                System.out.println(lines.length);
                return;
            }

            // 常规情况
            List<Integer> list = new ArrayList<>();
            int i = 0, k = 1;
            while (i < lines.length && k < lines.length) {
                if (lines[i].equals(lines[k])) {
                    k++;
                } else {
                    i = k;
                    k++;
                }
                list.add(k - i + 1);
            }
            Optional<Integer> max = list.stream().max(Integer::compareTo);
            System.out.println(max.get());
            return;
        }
    }
}
