package com.audition.demo8;

/**
 * @Author jinx
 * @Date 2022/7/5
 * @Desc
 */
public class Extended extends Base{
    public static final Integer FIELD_0 = 0;
    public static final String FIELD_A = "extended_field_a";
    public static String FIELD_B = "extended_field_b";
    public String FIELD_C = "extended_field_c";

    static {
        System.out.println("extended_static_block_init");
    }
    public Extended(){
        System.out.println("extended_construct_init");
    }
    public static void methodA(){
        System.out.println("extended_method_a");
    }
    public void methodB(){
        System.out.println("extended_method_b");
    }
}
