package com.pattern.demo18_mediator.demo2;

/**
 * Desc:
 * Created by jinx on 2017/9/4.
 */
public abstract class AbstractColleague {

    protected AbstractMediator abstractMediator;

    public AbstractColleague(AbstractMediator abstractMediator) {
        this.abstractMediator = abstractMediator;
    }

}
