package com.pattern.demo22_vistor;

import lombok.Data;

/**
 * @author jinx
 * @date 2018/08/07 23:48
 * Desc:
 */
@Data
public class Manager extends Employee {
    private String performance;

    @Override
    protected String getOtherInfo() {
        return " 业绩：" + this.performance;
    }
}
