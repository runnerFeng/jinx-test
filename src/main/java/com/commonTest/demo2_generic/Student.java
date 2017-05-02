package com.commonTest.demo2_generic;

import java.util.Date;
import java.util.List;

/**
 * Desc:
 * Created by lf on 2017/2/16
 */
public class Student {
    private int id;
    private String name;
    private Date birthDay;
    private List<B> bList;

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

    public List<B> getbList() {
        return bList;
    }

    public void setbList(List<B> bList) {
        this.bList = bList;
    }
}
