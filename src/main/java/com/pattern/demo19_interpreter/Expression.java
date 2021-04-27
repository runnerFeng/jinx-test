package com.pattern.demo19_interpreter;

import java.util.HashMap;

/**
 * Desc:
 * Created by jinx on 2017/9/6.
 */
public abstract class Expression {
    public abstract int interpreter(HashMap<String, Integer> var);
}
