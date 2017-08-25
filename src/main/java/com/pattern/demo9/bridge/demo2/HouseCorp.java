package com.pattern.demo9.bridge.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/24.
 */
public class HouseCorp extends Corp {
    public HouseCorp(House house) {
        super(house);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚钱了");
    }
}
