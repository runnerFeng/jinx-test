package com.audition.demo2;

/**
 * @author jinx
 * @date 2019/3/27 14:45
 * Desc:synchronized同步方法的测试一个线程异常后会不会释放锁资源:结论是会释放锁对象,jvm会让线程释放锁
 */
public class Test {
    public static void main(String[] args) {
        ObjectService objectService = new ObjectService();
        ThreadA threadA = new ThreadA(objectService);
        ThreadB threadB = new ThreadB(objectService);
        threadA.start();
        threadB.start();
    }
}
