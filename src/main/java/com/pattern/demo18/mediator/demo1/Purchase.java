package com.pattern.demo18.mediator.demo1;

/**
 * Desc:
 * Created by jinx on 2017/9/4.
 */
public class Purchase {
    public void buyIBMComputer(int number) {
        Stock stock = new Stock();
        Sale sale = new Sale();
        int saleStatus = sale.getSaleStatus();
        if (saleStatus > 80) {
            System.out.println("采购IBM电脑：" + number + "台");
            stock.increase(number);
        } else {
            System.out.println("采购IBM电脑：" + number / 2 + "台");
            stock.increase(number / 2);
        }
    }

    public void refuseBuyIBM() {
        System.out.println("不再采购IBM电脑");
    }

}
