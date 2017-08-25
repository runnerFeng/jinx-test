package com.pattern.demo9.bridge.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/24.
 */
public abstract class Corp {
    private Product product;

    public Corp(Product product) {
        this.product = product;
    }

    public void makeMoney() {
        this.product.beProducted();
        this.product.beSelled();
    }
}
