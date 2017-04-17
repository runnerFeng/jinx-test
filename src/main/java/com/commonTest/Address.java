package com.commonTest;

import javax.persistence.Embeddable;

/**
 * Desc:
 * Created by lf on 2017/4/10
 */
@Embeddable
public class Address {
    private String province;
    private String city;
    private String area;

    /**
     * 给一个构造函数，初始化改值对象
     *
     * @param area
     */
    public Address(String area) {
        this.area = area;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
