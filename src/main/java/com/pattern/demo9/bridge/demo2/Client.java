package com.pattern.demo9.bridge.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/24.
 */
public class Client {
    public static void main(String[] args) {
        HouseCorp houseCorp = new HouseCorp(new House());
        houseCorp.makeMoney();

//        ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new Clothes());
        ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new IPod());
        shanZhaiCorp.makeMoney();
    }
}
