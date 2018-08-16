package com.pattern.demo9.bridge.demo2;

/**
 * Desc:1.业务抽象角色引用业务实现角色，或者说业务抽象角色的部分实现是由业务实现角色完成的。
 *      2.桥梁模式描述了类间弱关联关系。
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
