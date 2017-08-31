package com.pattern.demo7.template;

/**
 * Desc:
 * Created by jinx on 2017/8/11.
 */
public class HummerH1Model extends HummerModel {

    private boolean alarmFlag =false;
    @Override
    protected void start() {
        System.out.println("H1型号启动");
    }

    @Override
    protected void alarm() {
        System.out.println("H1型号鸣笛");
    }

    @Override
    protected void engineBoom() {
        System.out.println("H1型号引擎声是这样的");
    }

    @Override
    protected void stop() {
        System.out.println("H1型号熄火");
    }

    //钩子方法，子类重写，覆盖父类默认值
    @Override
    protected boolean isAlarm() {
        return alarmFlag;
    }

    //提供set方法，由客户端控制要不要响
    public void setAlarmFalg(boolean flag){
        this.alarmFlag = flag;
    }
}
