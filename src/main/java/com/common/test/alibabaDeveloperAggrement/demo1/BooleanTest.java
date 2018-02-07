package com.common.test.alibabaDeveloperAggrement.demo1;

/**
 * @author jinx
 * @date 2018/02/07 22:21
 * Desc:boolean变量定义规约
 */
public class BooleanTest {
    private boolean isDelete;
    //boolean类型的变量定义时不要加is,否则部分框架解析会出现序列化错误
    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
