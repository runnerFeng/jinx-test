package com.pattern.demo18.mediator.demo1;

/**
 * Desc:
 * Created by jinx on 2017/9/4.
 */
public class Stock {

    private static int COMPUTER_NUMBER = 100;

    //增加库存
    public void increase(int number) {
        COMPUTER_NUMBER += number;
        System.out.println("库存数量为：" + COMPUTER_NUMBER);
    }

    //降低库存
    public void decrease(int number) {
        COMPUTER_NUMBER -= number;
    }

    //获得库存数量
    public int getScockNumber() {
        return COMPUTER_NUMBER;
    }

    //清货
    public void clearStock() {
        Purchase purchase = new Purchase();
        Sale sale = new Sale();
        System.out.println("需要清理了的存货数量为：" + COMPUTER_NUMBER);
        //折价销售
        sale.offSale();
        //不再采购
        purchase.refuseBuyIBM();
    }
}
