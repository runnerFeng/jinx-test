package com.pattern.demo19_interpreter;

import java.util.HashMap;

/**
 * Desc:
 * Created by jinx on 2017/9/6.
 */
public class SubExpression extends SymbolExpression {
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }
}
