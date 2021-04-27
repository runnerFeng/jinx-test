package com.pattern.demo18_mediator.demo2;

/**
 * Created by jinx on 2017/9/4.
 * Desc:中介者模式适用于多个对象紧密耦合，耦合的标准可以这样来衡量:在类图中出现了蜘蛛网状结构，在这种情况下一定要考虑使用中介者模式，
 * 有利于把蜘蛛网梳理成一个星形结构，使原本复杂混乱关系变得清晰简单。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("------采购人员采购电脑--------");
        AbstractMediator mediator = new Mediator();

        Purchase purchase = new Purchase(mediator);
        purchase.buyIBMComputer(100);

        System.out.println("\n------销售人员销售电脑--------");
        Sale sale = new Sale(mediator);
        sale.sellIBMComputer(1);

        //库房管理人员管理库存
        System.out.println("\n------库房管理人员清库处理--------");
        Stock stock = new Stock(mediator);
        stock.clearStock();
    }
}
