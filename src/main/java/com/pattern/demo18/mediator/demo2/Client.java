package com.pattern.demo18.mediator.demo2;

/**
 * Desc:
 * Created by jinx on 2017/9/4.
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
