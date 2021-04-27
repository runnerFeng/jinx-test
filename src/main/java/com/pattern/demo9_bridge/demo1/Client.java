package com.pattern.demo9_bridge.demo1;

/**
 * Desc:
 * Created by jinx on 2017/8/15.
 */
public class Client {
    public static void main(String[] args) {
        HouseCorp houseCorp = new HouseCorp();
        houseCorp.makeMoney();
        ClothesCorp clothesCorp = new ClothesCorp();
        clothesCorp.makeMoney();
        IPodCorp iPodCorp = new IPodCorp();
        iPodCorp.makeMoney();

    }
}



                                                  