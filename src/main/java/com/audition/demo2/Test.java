package com.audition.demo2;

/**
 * @author jinx
 * @date 2019/3/27 14:45
 * Desc:synchronized同步方法的测试一个线程异常后会不会释放锁资源:结论是会释放锁对象,jvm会让线程释放锁。
 * lock()方法发生异常时不会释放锁，故lock.unlock()需在finally块中调用以保证不会出现死锁。
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
