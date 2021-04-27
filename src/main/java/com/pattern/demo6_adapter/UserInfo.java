package com.pattern.demo6_adapter;

/**
 * Desc:
 * Created by jinx on 2017/8/10.
 */
public class UserInfo implements IUserInfo {
    @Override
    public String getUserName() {
        System.out.println("员工姓名");
        return null;
    }

    @Override
    public String getHomeAddress() {
        System.out.println("家庭地址");
        return null;
    }

    @Override
    public String getMobileNumber() {
        System.out.println("手机号码");
        return null;
    }

    @Override
    public String getOfficeTelNumber() {
        System.out.println("办公室座机号码");
        return null;
    }

    @Override
    public String getJobPosition() {
        System.out.println("职位");
        return null;
    }

    @Override
    public String getHomeTelNumber() {
        System.out.println("家庭电话");
        return null;
    }
}
