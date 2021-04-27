package com.pattern.demo18_mediator.demo2;

/**
 * Desc:
 * Created by jinx on 2017/9/4.
 */
public abstract class AbstractMediator {
    protected Sale sale;
    protected Purchase purchase;
    protected Stock stock;

    public AbstractMediator() {
        this.sale = new Sale(this);
        this.purchase = new Purchase(this);
        this.stock = new Stock(this);
    }

    public abstract void execute(String str, Object... objects);

}
