package com.pattern.demo13_observer.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/28.
 */
public class HanFeiZi implements IHanFeiZi {
    private boolean isHaveBreakfast = false;
    private boolean isHaveFun = false;

    @Override
    public void haveBreakfast() {
        System.out.println("韩非子：开始吃饭");
        this.isHaveBreakfast = true;
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子:开始娱乐");
        this.isHaveFun = true;
    }

    public boolean isHaveBreakfast() {
        return isHaveBreakfast;
    }

    public void setHaveBreakfast(boolean haveBreakfast) {
        isHaveBreakfast = haveBreakfast;
    }

    public boolean isHaveFun() {
        return isHaveFun;
    }

    public void setHaveFun(boolean haveFun) {
        isHaveFun = haveFun;
    }
}
