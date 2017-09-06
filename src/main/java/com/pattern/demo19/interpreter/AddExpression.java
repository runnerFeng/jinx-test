package com.pattern.demo19.interpreter;

import java.util.HashMap;

/**
 * Desc:
 * Created by jinx on 2017/9/6.
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
