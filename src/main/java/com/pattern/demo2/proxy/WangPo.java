package com.pattern.demo2.proxy;

/**
 * Desc:
 * Created by jinx on 2017/8/5.
 */
public class WangPo implements KindWomen {

    private KindWomen kindWomen;

    public WangPo() {
        kindWomen = new PanJinLian();
    }

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
