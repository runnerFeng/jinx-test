package com.pattern.demo13.observer;

/**
 * Desc:
 * Created by jinx on 2017/8/28.
 */
public class Watch extends Thread {
    private IHanFeiZi hanFeiZi;
    private ILiSi liSi;
    private String type;

    public Watch(IHanFeiZi hanFeiZi, ILiSi liSi, String type) {
        this.hanFeiZi = hanFeiZi;
        this.liSi = liSi;
        this.type = type;
    }

    @Override
    public void run() {
        while (true) {
            if (this.type.equals("breakfast")) {

            }
        }
//        super.run();
    }

}
