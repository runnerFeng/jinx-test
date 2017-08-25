package com.pattern.demo11.decorator.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/25.
 */
public class SortDecorator extends Decorator {
    public SortDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    public void reportScore() {
        System.out.println("我是排名第38名...");
    }

    @Override
    public void report() {
        this.reportScore();
        super.report();
    }
}
