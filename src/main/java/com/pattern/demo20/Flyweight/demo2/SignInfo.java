package com.pattern.demo20.Flyweight.demo2;

/**
 * Desc:
 * Created by jinx on 2017/9/7.
 */
public class SignInfo {
    private int id;
    private String location; //地点
    private String subject; //科目
    private String postAddress; //邮寄地址

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }
}
