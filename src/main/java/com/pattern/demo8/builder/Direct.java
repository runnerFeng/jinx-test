package com.pattern.demo8.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:导演类，对建造器做一个单独处理
 * Created by jinx on 2017/8/15.
 */
public class Direct {
    private List<String> sequence = new ArrayList<>();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private BMWBuilder bmwBuilder = new BMWBuilder();

    //生产不同需求的奔驰
    public BenzModel getABenzModel() {
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSetSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    public BenzModel getBBenzModel() {
        this.sequence.clear();
        this.sequence.add("engineBoom");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSetSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    public BenzModel getCBenzModel() {
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("engineBoom");
        this.sequence.add("alarm");
        this.sequence.add("stop");
        this.benzBuilder.setSetSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    //生产不同需求的宝马
    public BMWModel getABMWModel() {
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.bmwBuilder.setSetSequence(this.sequence);
        return (BMWModel) this.bmwBuilder.getCarModel();
    }

    public BMWModel getBBMWModel() {
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("engineBoom");
        this.sequence.add("stop");
        this.bmwBuilder.setSetSequence(this.sequence);
        return (BMWModel) this.bmwBuilder.getCarModel();
    }
}
