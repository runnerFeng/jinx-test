package com.pattern.demo8_builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:产品类
 * Created by jinx on 2017/8/11.
 */
public abstract class CarModel {

    private List<String> sequence = new ArrayList<>();

    protected abstract void start();

    protected abstract void alarm();

    protected abstract void engineBoom();

    protected abstract void stop();

    final public void run() {
        for (int i = 0; i < sequence.size(); i++) {
            String actionName = sequence.get(i);
            if ("start".equalsIgnoreCase(actionName)) {
                this.start();
            }
            if ("alarm".equalsIgnoreCase(actionName)) {
                this.alarm();
            }
            if ("engineBoom".equalsIgnoreCase(actionName)) {
                this.engineBoom();
            }
            if ("stop".equalsIgnoreCase(actionName)) {
                this.stop();
            }
        }
    }

    public void setSequence(List<String> sequence) {
        this.sequence = sequence;
    }

}
