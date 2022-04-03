package com.common.test.demo55_getCNYRate;

import lombok.Data;

/**
 * @Author jinx
 * @Date 2022/4/2
 * @Desc
 */
@Data
public class Record {
    private String vrtCode;
    /**
     * price
     */
    private String price;
    private String bp;
    /**
     * symbolName
     */
    private String vrtName;
    /**
     * symbolEnName
     */
    private String vrtEName;
    private String foreignCName;
    private double bpDouble;
    private String approvedTime;
    private String approvedTimeEn;
    private String showDate;
    private String showDateForCn;
    private String lastMonthAvgPrice;
    private String monthPrice;
    private String quarterPrice;
    private String yearPrice;
    private boolean isShowBp;
    private boolean show;
    private String url;
    private String bannerPic;
    private String bannerCss;
}
