package com.audition.demo2;

/**
 * @author jinx
 * @date 2019/3/27 14:42
 * Desc:
 */
public class ThreadA extends Thread {
    private ObjectService objectService;

    public ThreadA(ObjectService objectService) {
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.serviceMethodA();
    }
}
