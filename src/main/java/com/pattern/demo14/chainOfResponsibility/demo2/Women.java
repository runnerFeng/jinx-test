package com.pattern.demo14.chainOfResponsibility.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public class Women implements IWomen {
    //妇女的类型 1.未出嫁 2.出嫁 3.夫死
    private int type = 0;
    //妇女的请示
    private String request;

    public Women(int type, String request) {
        this.type = type;
        switch (this.type) {
            case 1:
                this.request = "女儿的请示是：" + request;
                break;
            case 2:
                this.request = "妻子的请示是：" + request;
                break;
            case 3:
                this.request = "母亲的请示是：" + request;
                break;
        }
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
