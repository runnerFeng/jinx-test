package com.common.test.test;

import com.alibaba.fastjson.JSONArray;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author jinx
 * @Date 2021/11/29
 * @Desc
 */
@Data
@AllArgsConstructor
public class AsiabillLocalPaymentMethod {
    private String isoCode;
    /**
     * 区域名
     */
    private String areaName;
    private String areaNameEn;
    private JSONArray curList;
    /**
     * 支付渠道
     */
    private String payChannel;
    /**
     * PmID
     */
    private String pmId;
    /**
     * logo
     */
    private String logoName;
}
