package com.audition.demo8;

/**
 * @Author jinx
 * @Date 2022/7/5
 * @Desc
 */
public class Base {
    public static final Integer FIELD_0 = 0;
    public static final String FIELD_A = "base_field_a";
    public static String FIELD_B = "base_field_b";
    public String FIELD_C = "base_field_c";

    static {
        System.out.println("base_static_block_init");
    }

    public Base(){
        System.out.println("base_construct_init");
    }
    public static void methodA(){
        System.out.println("base_method_a");
    }
    public void methodB(){
        System.out.println("base_method_b");
    }

}
