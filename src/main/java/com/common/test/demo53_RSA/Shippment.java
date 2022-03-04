package com.common.test.demo53_RSA;

import lombok.Data;

/**
 * @Author jinx
 * @Date 2022/2/10
 * @Desc
 */
@Data
public class Shippment {
    /**
     * 承运商编码
     */
    private String carrier_code;
    /**
     * 物流单号
     */
    private String tracking_no;
    /**
     * 发货国家缩写
     */
    private String country;
}
