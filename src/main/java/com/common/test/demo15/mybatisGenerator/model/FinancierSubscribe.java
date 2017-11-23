package com.common.test.demo15.mybatisGenerator.model;

import java.util.Date;

public class FinancierSubscribe {
    private Long id;

    private String secCode;

    private String secName;

    private String industry;

    private Long minAmountScale;

    private Long maxAmountScale;

    private Integer maxAmountLastDate;

    private Integer minAmountLastDate;

    private String purpose;

    private Date createTime;

    private Date updateTime;

    private String userId;

    public FinancierSubscribe(Long id, String secCode, String secName, String industry, Long minAmountScale, Long maxAmountScale, Integer maxAmountLastDate, Integer minAmountLastDate, String purpose, Date createTime, Date updateTime, String userId) {
        this.id = id;
        this.secCode = secCode;
        this.secName = secName;
        this.industry = industry;
        this.minAmountScale = minAmountScale;
        this.maxAmountScale = maxAmountScale;
        this.maxAmountLastDate = maxAmountLastDate;
        this.minAmountLastDate = minAmountLastDate;
        this.purpose = purpose;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userId = userId;
    }

    public FinancierSubscribe() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecCode() {
        return secCode;
    }

    public void setSecCode(String secCode) {
        this.secCode = secCode == null ? null : secCode.trim();
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName == null ? null : secName.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public Long getMinAmountScale() {
        return minAmountScale;
    }

    public void setMinAmountScale(Long minAmountScale) {
        this.minAmountScale = minAmountScale;
    }

    public Long getMaxAmountScale() {
        return maxAmountScale;
    }

    public void setMaxAmountScale(Long maxAmountScale) {
        this.maxAmountScale = maxAmountScale;
    }

    public Integer getMaxAmountLastDate() {
        return maxAmountLastDate;
    }

    public void setMaxAmountLastDate(Integer maxAmountLastDate) {
        this.maxAmountLastDate = maxAmountLastDate;
    }

    public Integer getMinAmountLastDate() {
        return minAmountLastDate;
    }

    public void setMinAmountLastDate(Integer minAmountLastDate) {
        this.minAmountLastDate = minAmountLastDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}