package com.pattern.demo22_vistor;

import lombok.Data;

/**
 * @author jinx
 * @date 2018/08/07 23:39
 * Desc:
 */
@Data
public abstract class Employee {
    public static final int MALE = 0;
    public static final int FEMALE = 1;

    private String name;
    private int salary;
    private int sex;

    final public void report() {
        String info = "姓名：" + this.name;
        info = info + " 性别：" + (this.sex == FEMALE ? "女" : "男");
        info = info + " 薪水：" + this.salary;
        info = info + this.getOtherInfo();
        System.out.println(info);
    }

    protected abstract String getOtherInfo();
}
