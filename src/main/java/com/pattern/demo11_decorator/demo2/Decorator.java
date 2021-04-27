package com.pattern.demo11_decorator.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/25.
 */
public abstract class Decorator implements SchoolReport {

    private SchoolReport schoolReport;

    public Decorator(SchoolReport schoolReport) {
        this.schoolReport = schoolReport;
    }

    @Override
    public void report() {
        this.schoolReport.report();
    }

    @Override
    public void sign(String name) {
        this.schoolReport.sign(name);
    }
}
