package com.think.in.java.chapter2;

/**
 * Desc:
 * Created by jinx on 2017/2/6
 */
public class Test1 {
    public static void main(String[] args) {
//        String s = "xx";
//        String s1 = new String("xx");
//        System.out.println(s.equals(s1));
//        System.out.println(s1==s);
//        float f = 1F;

//        char a = 0;
//        System.out.println(a);
//        System.out.println(test());

        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
    }

    public static int test(){
        int i = 0;
        return i;
    }

}
