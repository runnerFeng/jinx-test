package com.pattern.demo19.interpreter;

import java.util.HashMap;

/**
 * Desc:
 * Created by jinx on 2017/9/6.
 */
public class VarExpression extends Expression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
