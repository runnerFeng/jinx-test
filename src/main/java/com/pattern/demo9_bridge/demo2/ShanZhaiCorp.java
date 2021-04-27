package com.pattern.demo9_bridge.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/24.
 */
public class ShanZhaiCorp extends Corp {
    public ShanZhaiCorp(Product product) {
        super(product);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("我赚钱了");
    }
}
