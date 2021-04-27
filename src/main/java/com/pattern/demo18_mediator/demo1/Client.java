package com.pattern.demo18_mediator.demo1;

/**
 * Desc:
 * Created by jinx on 2017/9/4.
 */
public class Client {
    public static void main(String[] args) {
        //采购人员采购电脑
        System.out.println("------采购人员采购电脑--------");
        Purchase purchase = new Purchase();
        purchase.buyIBMComputer(100);
        //销售人员销售电脑
        System.out.println("\n------销售人员销售电脑--------");
        Sale sale = new Sale();
        sale.saleIBMComputer(1);
        //库房管理人员管理库存
        System.out.println("\n------库房管理人员清库处理--------");
        Stock stock = new Stock();
        stock.clearStock();
    }
}
