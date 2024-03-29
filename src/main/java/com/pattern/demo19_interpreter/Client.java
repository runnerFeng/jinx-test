package com.pattern.demo19_interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Desc:这个例子看着有点烦，解释器模式用的也比较少
 * Created by jinx on 2017/9/6.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        String expStr = getExpStr();
        //赋值
        HashMap<String, Integer> var = getValue(expStr);
        Calculator cal = new Calculator(expStr);
        System.out.println("运算结果为： " + expStr + "=" + cal.run(var));
    }

    public static String getExpStr() throws IOException {
        System.out.print("请输入表达式： ");
        return (new BufferedReader(new
                InputStreamReader(System.in))).readLine();
    }

    public static HashMap<String, Integer> getValue(String exprStr) throws
            IOException {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //解析有几个参数要传递
        for (char ch : exprStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                if (!map.containsKey(String.valueOf(ch))) { //解决重复参数的问题
                    System.out.print("请输入" + ch + "的值:");
                    String in = (new BufferedReader(new
                            InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }
        return map;
    }
}

