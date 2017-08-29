package com.pattern.demo13.observer.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/28.
 */
public class Watch extends Thread {
    private HanFeiZi hanFeiZi;
    private LiSi liSi;
    private String type;

    public Watch(HanFeiZi hanFeiZi, LiSi liSi, String type) {
        this.hanFeiZi = hanFeiZi;
        this.liSi = liSi;
        this.type = type;
    }

    @Override
    public void run() {
        while (true) {
            if (this.type.equals("breakfast")) {
//                System.out.println("///////////////"+this.hanFeiZi.isHaveBreakfast());
                if (this.hanFeiZi.isHaveBreakfast()) {
                    this.liSi.update("韩非子在吃饭");
                    this.hanFeiZi.setHaveBreakfast(false);
                }
            } else {
//                System.out.println("===================="+this.hanFeiZi.isHaveFun());
                if (hanFeiZi.isHaveFun()) {
                    this.liSi.update("韩非子在娱乐");
                    this.hanFeiZi.setHaveFun(false);
                }
            }
        }
    }

}
