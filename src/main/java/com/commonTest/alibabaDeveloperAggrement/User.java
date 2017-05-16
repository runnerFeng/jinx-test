package com.commonTest.alibabaDeveloperAggrement;

import javax.persistence.Embedded;

/**
 * Desc:hibernate值对象初始化是否为null测试
 * Created by lf on 2017/4/10
 */
public class User {
    private int id;
    private String userName;
    private String passsword;
    @Embedded
    private Address address;

    public User() {
        Address address = new Address("");
    }

    public static void main(String[] args) {
        User test = new User();
        System.out.println(test.getAddress());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
