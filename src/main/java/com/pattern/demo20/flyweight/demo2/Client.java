package com.pattern.demo20.flyweight.demo2;

/**
 * Desc:尽量使用池的概念
 * Created by jinx on 2017/9/7.
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            String subject = "科目" + i;
            for (int j = 0; j < 30; j++) {
                String key = subject + "考试地点" + j;
                SignInfoFactory.getSignInfo(key);
            }
        }
        System.out.println(SignInfoFactory.getSignInfo("科目1考试地点1").getId());

    }
}
