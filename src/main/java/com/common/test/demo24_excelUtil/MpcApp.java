package com.common.test.demo24_excelUtil;

import java.io.Serializable;
import java.util.Date;

public class MpcApp implements Serializable {
    private Integer id;

    private String name;

    private String desc;

    private String visitUrl;

    private Integer type;

    private Integer status;

    private Integer partyNumber;

    private Date updateTime;

    private String classifyCode;

    private String classifyName;

    private String systemCode;

    private String systemName;

    private String systemIndex;

    private String publishType;

    private String publishName;

    private Date publishTime;

    private Integer dowloadTotal;

    private Integer calculatedTotal;

    private Integer userId;

    private String icon;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getVisitUrl() {
        return visitUrl;
    }

    public void setVisitUrl(String visitUrl) {
        this.visitUrl = visitUrl == null ? null : visitUrl.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPartyNumber() {
        return partyNumber;
    }

    public void setPartyNumber(Integer partyNumber) {
        this.partyNumber = partyNumber;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getClassifyCode() {
        return classifyCode;
    }

    public void setClassifyCode(String classifyCode) {
        this.classifyCode = classifyCode == null ? null : classifyCode.trim();
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode == null ? null : systemCode.trim();
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    public String getSystemIndex() {
        return systemIndex;
    }

    public void setSystemIndex(String systemIndex) {
        this.systemIndex = systemIndex == null ? null : systemIndex.trim();
    }

    public String getPublishType() {
        return publishType;
    }

    public void setPublishType(String publishType) {
        this.publishType = publishType == null ? null : publishType.trim();
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName == null ? null : publishName.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getDowloadTotal() {
        return dowloadTotal;
    }

    public void setDowloadTotal(Integer dowloadTotal) {
        this.dowloadTotal = dowloadTotal;
    }

    public Integer getCalculatedTotal() {
        return calculatedTotal;
    }

    public void setCalculatedTotal(Integer calculatedTotal) {
        this.calculatedTotal = calculatedTotal;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", desc=").append(desc);
        sb.append(", visitUrl=").append(visitUrl);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", partyNumber=").append(partyNumber);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", classifyCode=").append(classifyCode);
        sb.append(", classifyName=").append(classifyName);
        sb.append(", systemCode=").append(systemCode);
        sb.append(", systemName=").append(systemName);
        sb.append(", systemIndex=").append(systemIndex);
        sb.append(", publishType=").append(publishType);
        sb.append(", publishName=").append(publishName);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", dowloadTotal=").append(dowloadTotal);
        sb.append(", calculatedTotal=").append(calculatedTotal);
        sb.append(", userId=").append(userId);
        sb.append(", icon=").append(icon);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}