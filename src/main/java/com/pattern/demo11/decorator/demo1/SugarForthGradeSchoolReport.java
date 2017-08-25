package com.pattern.demo11.decorator.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/25.
 */
public class SugarForthGradeSchoolReport extends ForthGradeSchooleReport {

    public void reportHighScore() {
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }

    public void reportSort() {
        System.out.println("我是排名第38名...");
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
        this.reportSort();
    }
}
