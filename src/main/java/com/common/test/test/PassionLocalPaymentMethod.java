package com.common.test.test;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author jinx
 * @Date 2021/11/11
 * @Desc
 */
@Data
@AllArgsConstructor
public class PassionLocalPaymentMethod {
    private String areaCode;
    private String areaName;
    private String payChannel;
    private String pmId;
    private String logoName;
}
