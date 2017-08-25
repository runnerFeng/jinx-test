package com.pattern.demo11.decorator.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/25.
 */
public class HighScoreDecorator extends Decorator {

    public HighScoreDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    public void reportHighScore() {
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }

    @Override
    public void report() {
        super.report();
        this.reportHighScore();
    }


}
