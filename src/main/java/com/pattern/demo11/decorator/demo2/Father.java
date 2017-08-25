package com.pattern.demo11.decorator.demo2;


/**
 * Desc:
 * Created by jinx on 2017/8/25.
 */
public class Father {
    public static void main(String[] args) {
        SchoolReport schoolReport = null;
        schoolReport = new ForthGradeSchooleReport();
//        schoolReport.report();

        schoolReport = new HighScoreDecorator(schoolReport);

        schoolReport = new SortDecorator(schoolReport);

        schoolReport.report();
        schoolReport.sign("小三");
    }
}
