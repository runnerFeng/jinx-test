package com.common.test.demo43_excelTest;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Aug
 * @Date: 2021-05-06 14:31
 * @Desc:
 */
@Data
public class RateReportResponse {
    private Long id;
    private String currency;
    private BigDecimal price;
    private String customerName;
    private String date;
}
