package com.commonTest.demo2;

import java.util.Date;

/**
 * Desc:
 * Created by lf on 2017/2/16
 */
public class Student {
    private int id;
    private String name;
    private Date birthDay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
