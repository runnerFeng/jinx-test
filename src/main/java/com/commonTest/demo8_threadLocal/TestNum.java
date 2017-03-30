package com.commonTest.demo8_threadLocal;

/**
 * Desc:
 * Created by lf on 2017/3/30
 */
public class TestNum {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {

    };
}
