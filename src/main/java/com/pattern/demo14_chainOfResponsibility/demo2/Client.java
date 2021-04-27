package com.pattern.demo14_chainOfResponsibility.demo2;


import java.util.ArrayList;
import java.util.Random;

/**
 * Desc:责任链模式屏蔽了请求的处理过程，你发起一个请求到底是谁处理的，这个你不用关心，只要你把请求抛给责任链的第一个处理者，
 * 最终会返回一个处理结果（当然也可以不做任何处理），作为请求者可以不用知道到底是需要谁来处理的，这是责任链模式的核心
 * Created by jinx on 2017/8/29.
 */
public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<IWomen> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Women(random.nextInt(4), "我要出去逛街"));
        }

        Hander father = new Father();
        Hander husband = new Husband();
        Hander son = new Son();
        father.setNextHander(husband);
        husband.setNextHander(son);

        for (IWomen iWomen : arrayList) {
            //直接调用第一级责任人，然后根据设置好的链往下传（如果该责任人不用处理的话）
            father.handleMesage(iWomen);
        }
    }
}
