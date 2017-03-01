package com.commonTest.demo5_jackson;

/**
 * Desc:扫描后接收身份证信息
 * Created by lf on 2017/2/21
 */
public class IDCardInfo {
    private String name;
    private String cardno;
    private String sex;
    private String folk;
    private String birthday;
    private String address;
    private String[] issue_authority;
    private String[] valid_period;
    private String[] header_pic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFolk() {
        return folk;
    }

    public void setFolk(String folk) {
        this.folk = folk;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getIssue_authority() {
        return issue_authority;
    }

    public void setIssue_authority(String[] issue_authority) {
        this.issue_authority = issue_authority;
    }

    public String[] getValid_period() {
        return valid_period;
    }

    public void setValid_period(String[] valid_period) {
        this.valid_period = valid_period;
    }

    public String[] getHeader_pic() {
        return header_pic;
    }

    public void setHeader_pic(String[] header_pic) {
        this.header_pic = header_pic;
    }
}
