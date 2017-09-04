package com.pattern.demo18.mediator.demo1;

import java.util.Random;

/**
 * Desc:
 * Created by jinx on 2017/9/4.
 */
public class Sale {

    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        int saleStatus = random.nextInt(100);
        System.out.println(saleStatus);
    }

    public void saleIBMComputer(int number) {
        Stock stock = new Stock();
        Purchase purchase = new Purchase();

        if (stock.getScockNumber() < number) {
            purchase.buyIBMComputer(number);
        }
        System.out.println("销售IBM电脑：" + number + "台");
        stock.decrease(number);
    }

    public int getSaleStatus() {
        Random random = new Random(System.currentTimeMillis());
        int saleStatus = random.nextInt(100);
        System.out.println("IBM电脑销售情况为：" + saleStatus);
        return saleStatus;
    }

    public void offSale() {
        Stock stock = new Stock();
        System.out.println("折价销售IBM电脑" + stock.getScockNumber() + "台");
    }

}
