package com.pattern.demo14.chainOfResponsibility.demo2;


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

        Father father = new Father();
        Husband husband = new Husband();
        Son son = new Son();
        father.setNextHander(husband);
        husband.setNextHander(son);

        for (IWomen iWomen : arrayList) {
            father.handleMesage(iWomen);
        }
    }
}
