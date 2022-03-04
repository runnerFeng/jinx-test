package com.common.test.demo53_RSA;

import lombok.Data;

import java.util.List;

/**
 * @Author jinx
 * @Date 2022/2/10
 * @Desc
 */
@Data
public class UploadTrackingNumber {
    /**
     * 通用参数
     */
    private String country;
    /**
     * 商户订单号
     */
    private String merchant_transaction_id;
    /**
     * 商户号
     */
    private String merchant_id;
    /**
     * 二级商户号，非必须
     */
    private String sub_merchant_id;
    /**
     * 物流详情列表
     */
    private List<Shippment> shipments;

}
