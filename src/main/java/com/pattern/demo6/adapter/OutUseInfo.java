package com.pattern.demo6.adapter;

import java.util.Map;

/**
 * Desc:
 * Created by jinx on 2017/8/10.
 */
public class OutUseInfo extends OuterUser implements IUserInfo {

    private Map baseInfo = super.getUserBaseInfo();
    private Map officeInfo = super.getUserOfficeInfo();
    private Map homeInfo = super.getUseHomeInfo();

    @Override
    public String getUserName() {
        return (String) baseInfo.get("userName");
    }

    @Override
    public String getHomeAddress() {
        return (String) homeInfo.get("homeAddress");
    }

    @Override
    public String getMobileNumber() {
        return (String) baseInfo.get("mobileNumber");
    }

    @Override
    public String getOfficeTelNumber() {
        return (String) officeInfo.get("officeTelNumber");
    }

    @Override
    public String getJobPosition() {
        return (String) officeInfo.get("jobPosition");
    }

    @Override
    public String getHomeTelNumber() {
        return (String) homeInfo.get("homeTelNumber");
    }

}
