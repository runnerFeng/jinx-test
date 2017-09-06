package com.pattern.demo19.interpreter;

/**
 * Desc:
 * Created by jinx on 2017/9/6.
 */
public abstract class SymbolExpression extends Expression {

    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
