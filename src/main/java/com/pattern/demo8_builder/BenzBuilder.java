package com.pattern.demo8_builder;

import java.util.List;

/**
 * Desc:建造者
 * Created by jinx on 2017/8/14.
 */
public class BenzBuilder extends CarBuilder {

    private CarModel benzModel = new BenzModel();

    @Override
    public void setSetSequence(List<String> sequenceList) {
        this.benzModel.setSequence(sequenceList);
    }

    @Override
    public CarModel getCarModel() {
        return this.benzModel;
    }
}
