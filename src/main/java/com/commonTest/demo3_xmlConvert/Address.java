package com.commonTest.demo3_xmlConvert;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Desc:
 * Created by lf on 2017/2/21
 */
@XStreamAlias("address")
public class Address {
    private String street;
    private int houseNo;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }
}
