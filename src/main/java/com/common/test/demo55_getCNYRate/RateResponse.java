package com.common.test.demo55_getCNYRate;

import lombok.Data;

import java.util.List;

/**
 * @Author jinx
 * @Date 2022/4/2
 * @Desc
 */
@Data
public class RateResponse {
    private Head head;
    private com.common.test.demo55_getCNYRate.Data data;
    private List<Record> records;
}
