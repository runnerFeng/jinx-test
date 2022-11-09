package com.audition.demo8;

/**
 * @Author jinx
 * @Date 2022/7/5
 * @Desc 输出对应值
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Base.FIELD_0);
        System.out.println(Base.FIELD_A);
        System.out.println(Base.FIELD_B);
        Base.methodA();
        new Base().methodB();

        System.out.println("------------");
        System.out.println(Extended.FIELD_A);
        System.out.println(Extended.FIELD_B);
        Extended.methodA();
        new Extended().methodB();

        System.out.println("------------");
        Base base = new Extended();
        System.out.println(base.FIELD_A);
        System.out.println(base.FIELD_B);
        System.out.println(base.FIELD_C);
        base.methodA();
        base.methodB();

        System.out.println("------------");
        Extended extended = new Extended();
    }
}
