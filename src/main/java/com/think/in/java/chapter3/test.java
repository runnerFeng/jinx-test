package com.think.in.java.chapter3;

import java.util.Random;

/**
 * Desc:
 * Created by jinx on 2017/2/12.
 */
public class test {
    public static void main(String[] args) {
//        util.Random()随机数
        Random random = new Random();
        Random random2 = new Random(47);
//generator the different result
        System.out.println(random.nextInt(10));
  //generator the same result
        System.out.println(random2.nextInt(10));

//        一元加号唯一的作用仅仅是将较小类型的操作数提升为int....

Short s = 10000;
Integer i = Integer.valueOf(s);
System.out.println(s.getClass());
System.out.println(i.getClass());
    }
}
