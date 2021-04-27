package com.pattern.demo13_observer.demo4;


import java.util.Observable;
import java.util.Observer;

/**
 * Desc:
 * Created by jinx on 2017/8/30.
 */
public class WangSi implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("王斯：观察到李斯活动，开始向老板汇报了...");
        this.reportToQiShiHuang(arg.toString());
        System.out.println("王斯：汇报完毕，秦老板赏给他两个萝卜吃吃...\n");
    }

    private void reportToQiShiHuang(String reportContext) {
        System.out.println("王斯：报告，秦老板！韩非子有活动了--->" + reportContext);
    }
}
