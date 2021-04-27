package com.pattern.demo13_observer.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/28.
 */
public class HanFeiZi implements IHanFeiZi {
    private LiSi liSi = new LiSi();

    @Override
    public void haveBreakfast() {
        System.out.println("韩非子：开始吃饭");
        this.liSi.update("韩非子在吃饭");
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子:开始娱乐");
        this.liSi.update("韩非子在娱乐");
    }

}
