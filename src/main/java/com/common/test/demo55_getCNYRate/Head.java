package com.common.test.demo55_getCNYRate;

import lombok.Data;

/**
 * @Author jinx
 * @Date 2022/4/2
 * @Desc
 */
@Data
public class Head {
    private String version;
    private String provider;
    private String req_code;
    private String rep_code;
    private String rep_message;
    private long ts;
    private String producer;
}
