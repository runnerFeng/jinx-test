package com.pattern.demo8_builder;

import java.util.List;

/**
 * Desc:建造者
 * Created by jinx on 2017/8/14.
 */
public class BMWBuilder extends CarBuilder {

    private BMWModel bmwModel = new BMWModel();

    @Override
    public void setSetSequence(List<String> sequenceList) {
        this.bmwModel.setSequence(sequenceList);
    }

    @Override
    public CarModel getCarModel() {
        return this.bmwModel;
    }

}
