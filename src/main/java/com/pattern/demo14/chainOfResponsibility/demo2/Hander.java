package com.pattern.demo14.chainOfResponsibility.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public abstract class Hander {
    //处理级别
    private int level;
    private Hander nextHander;

    public Hander(int level) {
        this.level = level;
    }

    public final void handleMesage(IWomen women) {
        if (women.getTyp() == this.level) {
            this.response(women);
        } else {
            if (this.nextHander != null) {
                this.nextHander.handleMesage(women);
                return;
            } else {
                System.out.println("没人处理了");
            }
        }
    }

    public void setNextHander(Hander nextHander) {
        this.nextHander = nextHander;
    }

    public abstract void response(IWomen women);
}
