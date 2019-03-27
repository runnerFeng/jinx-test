package com.audition.demo2;

/**
 * @author jinx
 * @date 2019/3/27 14:30
 * Desc:
 */
public class ObjectService {

    synchronized public void serviceMethodA() {
        System.out.println("synchronized method serviceMethodA() start");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        throw new RuntimeException();
    }

    synchronized public void serviceMethodB() {
        System.out.println("synchronized method serviceMethodB() start");
    }

}
