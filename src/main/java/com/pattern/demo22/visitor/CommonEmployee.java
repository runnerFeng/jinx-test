package com.pattern.demo22.visitor;

import lombok.Data;

/**
 * @author jinx
 * @date 2018/08/07 23:46
 * Desc:
 */
@Data
public class CommonEmployee extends Employee {
    private String job;

    @Override
    protected String getOtherInfo() {
        return " 工作：" + this.job;
    }
}
