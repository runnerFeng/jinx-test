package com.think.in.java.chapter19.demo1;

/**
 * Desc:
 * Created by jinx on 2017/2/27.
 */
public class Upcastenum {
    enum Search{HITHER,YON}

    public static void main(String[] args) {
        Search[] vals = Search.values();
        for (Search val : vals) {
            System.out.println(val);
        }
        System.out.println("-----------------------------");
        Enum e = Search.HITHER;
        for (Enum val : e.getClass().getEnumConstants()) {
            System.out.println(val);
        }
    }
}
