package com.pattern.demo2.proxy;

/**
 * Desc:
 * Created by jinx on 2017/8/5.
 */
public class WangPo implements KindWomen {

    private KindWomen kindWomen;

    //默认无参构造方法传潘金莲
    public WangPo() {
        this.kindWomen = new PanJinLian();
    }

    //有参构造方法可以传其他被代理类
    public WangPo(KindWomen kindWomen) {
        this.kindWomen = kindWomen;
    }

    @Override
    public void makeEyesWihtMan() {
        this.kindWomen.makeEyesWihtMan();
    }

    @Override
    public void happyWithMan() {
        this.kindWomen.happyWithMan();
    }
}
