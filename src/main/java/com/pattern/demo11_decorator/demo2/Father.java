package com.pattern.demo11_decorator.demo2;


/**
 * Desc:引用子类对象的链式传递技巧
 * Created by jinx on 2017/8/25.
 */
public class Father {
    public static void main(String[] args) {
        SchoolReport schoolReport = null;
        schoolReport = new ForthGradeSchoolReport();

//        schoolReport.report();
        schoolReport = new HighScoreDecorator(schoolReport);

        schoolReport = new SortDecorator(schoolReport);

        schoolReport.report();
        schoolReport.sign("小三");
    }
}
