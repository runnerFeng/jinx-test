package com.javaGuide.java.basic.demo2;

/**
 * @Author: fans
 * @Date: 2019-12-03 20:24
 * @Desc:String,StringBuilder,StringBuffer区别，String为什么是不可变的？
 *       1.可变性
 *       2.线程安全性
 *       3.性能：每次对String类型进行改变的时候都会对生成一个新的String对象，然后将指针指向新的String对象；
 *              StringBuffer每次都对StringBuffer对象本身进行操作，而不是生成新的对象并改变对象引用；
 *              相同情况下StringBuilder相比StringBuffer仅能提升10%～15%的性能，但却要冒多线程不安全的风险。
 *       4.总结：操作少量数据：适用String
 *              单线程操作字符串缓冲区下操作大量数据：适用StringBuilder
 *              多线程操作字符串缓冲区下操作大量数据：适用StringBuffer
 */
public class Test1 {
    public static void main(String[] args) {

        // private final char value[],故String对象不可变
        // 对象不可变，可以认为是常量，故线程安全
        String string = "leona";

        // char[] value,故该对象是可变的
        // 未对方法加同步锁，故非线程安全
        StringBuilder stringBuilder = new StringBuilder();

        // char[] value,故该对象是可变的
        // 对方法或者调用的方法加了同步锁，故线程安全
        StringBuffer stringBuffer = new StringBuffer();
    }
}
