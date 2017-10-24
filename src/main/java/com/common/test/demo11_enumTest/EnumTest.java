package com.common.test.demo11_enumTest;

/**
 * Desc:
 * Created by jinx on 2017/5/7.
 */
public enum  EnumTest {

    New
    ,WAIT_PAY
    ,PAID{
        @Override
        void expired() {

        }
    }
    ,CANCEL
    ,EXPIRED;
    void expired(){throw new RuntimeException("error state!");}
}
