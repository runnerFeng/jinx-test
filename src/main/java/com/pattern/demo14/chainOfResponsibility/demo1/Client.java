package com.pattern.demo14.chainOfResponsibility.demo1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<IWomen> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Women(random.nextInt(4), "我要出去逛街"));
        }

        IHandler father = new Father();
        IHandler husband = new Husband();
        IHandler son = new Son();

        for (IWomen iWomen : arrayList) {
            if (iWomen.getTyp() == 1) {
                System.out.println("女儿向父亲请示");
                father.handleMessage(iWomen);
            }
            if (iWomen.getTyp() == 2) {
                System.out.println("妻子向丈夫请示");
                husband.handleMessage(iWomen);
            }
            if (iWomen.getTyp() == 3) {
                System.out.println("母亲向儿子请示");
                son.handleMessage(iWomen);
            }
        }
    }
}
