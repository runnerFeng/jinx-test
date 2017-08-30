package com.pattern.demo6.adapter;

/**
 * Desc:适配器模式 类适配器（继承关系） 对象适配器（组合关系）
 * Created by jinx on 2017/8/10.
 */
public class App {
    public static void main(String[] args) {
        //没有与外界对接
//        IUserInfo yongGirl = new UserInfo();
//        for (int i = 0; i < 101; i++) {
//            yongGirl.getMobileNumber();
//        }
        //对接之后
        IUserInfo yongGirl = new OutUseInfo();
        for (int i = 0; i < 101; i++) {
            System.out.println(yongGirl.getUserName() + "-------" + yongGirl.getMobileNumber());
        }
    }
}
