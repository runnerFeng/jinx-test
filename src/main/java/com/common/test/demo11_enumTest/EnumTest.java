package com.common.test.demo11_enumTest;

/**
 * Desc:
 * Created by jinx on 2017/5/7.
 */
public enum EnumTest {

    New, WAIT_PAY, PAID {
        @Override
        void expired(boolean flag) {
            if (getFlag()) {
                System.out.println("sub method executed!");
            } else {
                System.out.println("sub method not executed!");
            }
        }
    }, CANCEL, EXPIRED;

    EnumTest() {
    }

    void expired(boolean flag) {
//        throw new RuntimeException("error state!");
        if (flag) {
            System.out.println("parent method1!");
        } else {
            System.out.println("parent method2!");
        }
    }

    boolean getFlag() {
        return true;
    }
}
