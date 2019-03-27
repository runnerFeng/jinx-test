package com.audition.demo2;

/**
 * @author jinx
 * @date 2019/3/27 14:45
 * Desc:
 */
public class ThreadB extends Thread {
    private ObjectService objectService;

    public ThreadB(ObjectService objectService) {
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.serviceMethodB();
    }
}
