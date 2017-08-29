package com.pattern.demo13.observer.demo3;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public class LiSi implements Observer {
    @Override
    public void update(String context) {
        System.out.println("李斯：观察到李斯活动，开始向老板汇报了...");
        this.reportToQiShiHuang(context);
        System.out.println("李斯：汇报完毕，秦老板赏给他两个萝卜吃吃...");
    }

    private void reportToQiShiHuang(String reportContext) {
        System.out.println("李斯：报告，秦老板！韩非子有活动了--->" + reportContext);
    }

}
