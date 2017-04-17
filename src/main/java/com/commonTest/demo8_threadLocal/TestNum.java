package com.commonTest.demo8_threadLocal;

/**
 * Desc:
 * Created by lf on 2017/3/30
 */
public class TestNum {

    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 0;
        }
    };

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

}
