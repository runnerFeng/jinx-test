package com.pattern.demo11_decorator.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/25.
 */
public class Father {
    public static void main(String[] args) {
//        SchoolReport schoolReport = new ForthGradeSchooleReport();
//        schoolReport.report();
        //还没装饰怎么签字？打死你。。。
//        schoolReport.sign();

        SchoolReport schoolReport = new SugarForthGradeSchoolReport();
        schoolReport.report();
        schoolReport.sign("小三");
    }
}
