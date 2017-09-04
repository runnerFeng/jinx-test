package com.pattern.demo18.mediator.demo2;

/**
 * Desc:
 * Created by jinx on 2017/9/4.
 */
public class Purchase extends AbstractColleague {

    public Purchase(AbstractMediator abstractMediator) {
        super(abstractMediator);
    }

    //采购IBM型号的电脑
    public void buyIBMComputer(int number) {
        super.abstractMediator.execute("purchase.buy", number);
    }

    //不在采购IBM电脑
    public void refuseBuyIBM() {
        System.out.println("不再采购IBM电脑");
    }

}
