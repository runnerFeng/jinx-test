package com.pattern.demo14.chainOfResponsibility.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public class Women implements IWomen {
    //妇女的类型 1.未出嫁 2.出嫁 3.夫死
    private int type = 0;
    //妇女的请示
    private String request = "";

    public Women(int type, String request) {
        this.type = type;
        this.request = request;
    }

    @Override
    public int getTyp() {
        return this.type;
    }

    @Override
    public String getRequest() {
        return this.request;
    }
}
