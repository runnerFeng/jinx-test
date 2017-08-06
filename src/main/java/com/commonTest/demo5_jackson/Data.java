package com.commonTest.demo5_jackson;

import java.util.List;

public class Data {

    private String total;
    private List<Items> items;
    private String accountType;//账户类型
    private String shrName;//股东名称
    private String shrType; //股东类别
    private String stateOwnPrpty; //国有属性
    private String pubPrpty; //上市属性
    private String captlPrpty; //资本属性
    private String uniAcctNbr;//一码通号
    private String certNo; //股东证件号码
    private String certType; //股东证件类型
    private String zczh;//是否是定向资产管理专用证券账户 0：否；其他：是
    private String jjcp;//是否基金公司理财产品 0：否；其他：是

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getShrName() {
        return shrName;
    }

    public void setShrName(String shrName) {
        this.shrName = shrName;
    }

    public String getShrType() {
        return shrType;
    }

    public void setShrType(String shrType) {
        this.shrType = shrType;
    }

    public String getStateOwnPrpty() {
        return stateOwnPrpty;
    }

    public void setStateOwnPrpty(String stateOwnPrpty) {
        this.stateOwnPrpty = stateOwnPrpty;
    }

    public String getPubPrpty() {
        return pubPrpty;
    }

    public void setPubPrpty(String pubPrpty) {
        this.pubPrpty = pubPrpty;
    }

    public String getCaptlPrpty() {
        return captlPrpty;
    }

    public void setCaptlPrpty(String captlPrpty) {
        this.captlPrpty = captlPrpty;
    }

    public String getUniAcctNbr() {
        return uniAcctNbr;
    }

    public void setUniAcctNbr(String uniAcctNbr) {
        this.uniAcctNbr = uniAcctNbr;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getZczh() {
        return zczh;
    }

    public void setZczh(String zczh) {
        this.zczh = zczh;
    }

    public String getJjcp() {
        return jjcp;
    }

    public void setJjcp(String jjcp) {
        this.jjcp = jjcp;
    }
}
