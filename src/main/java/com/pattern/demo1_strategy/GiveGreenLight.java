package com.pattern.demo1_strategy;

/**
 * Desc:
 * Created by jinx on 2017/8/5.
 */
public class GiveGreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("求吴国太开个绿灯,放行!");
    }
}
