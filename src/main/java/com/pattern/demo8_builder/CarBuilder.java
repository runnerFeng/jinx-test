package com.pattern.demo8_builder;

import java.util.List;

/**
 * Desc:建造者
 * Created by jinx on 2017/8/14.
 */
public abstract class CarBuilder {

    public abstract void setSetSequence(List<String> sequenceList);

    public abstract CarModel getCarModel();
}
