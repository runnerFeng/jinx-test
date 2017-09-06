package com.pattern.demo19.interpreter;

import java.util.HashMap;
import java.util.Stack;

/**
 * Desc:
 * Created by jinx on 2017/9/6.
 */
public class Calculator {
    private Expression expression;

    public Calculator(String expStr) {
        Stack<Expression> stack = new Stack<>();

        char[] charArray = expStr.toCharArray();

        Expression left;
        Expression right;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+': //加法
                    //加法结果放到堆栈中
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default: //公式中的变量
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
            }
        }
        this.expression = stack.pop();
    }

    //开始运算
    public int run(HashMap<String, Integer> var) {
        return this.expression.interpreter(var);
    }

//    public static void main(String[] args) {
//        Stack stack = new Stack();
//        String str = "a+b";
//        char[] chars  = str.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            String arg = chars[i];
//            System.out.println(arg);
//        }
//    }
}
