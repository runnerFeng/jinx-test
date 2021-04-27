package com.pattern.demo13_observer.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/28.
 */
public class LiSi implements ILiSi {

    @Override
    public void update(String context) {
        System.out.println("李斯：观察到韩非子活动，开始向老板汇报");
        this.reportToQingShiHuang(context);
        System.out.println("李斯：汇报完毕。");
    }

    private void reportToQingShiHuang(String context) {
        System.out.println("李斯：报告老板，韩非子有活动了：" + context);
    }

}
