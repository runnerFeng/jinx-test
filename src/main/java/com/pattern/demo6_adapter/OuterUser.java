package com.pattern.demo6_adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * Created by jinx on 2017/8/10.
 */
public class OuterUser implements IOuterUser {
    @Override
    public Map getUserBaseInfo() {
        Map baseInfoMap = new HashMap();
        baseInfoMap.put("userName", "刘锋");
        baseInfoMap.put("mobileNumber", "110");
        return baseInfoMap;
    }

    @Override
    public Map getUserOfficeInfo() {
        Map officeInfoMap = new HashMap();
        officeInfoMap.put("jobPosition", "Boss");
        officeInfoMap.put("officeTelNumber", "110120");
        return officeInfoMap;
    }

    @Override
    public Map getUseHomeInfo() {
        Map homeInfoMap = new HashMap();
        homeInfoMap.put("homeAddress", "甘肃天水");
        homeInfoMap.put("homeTelNumber", "110110");
        return homeInfoMap;
    }
}
