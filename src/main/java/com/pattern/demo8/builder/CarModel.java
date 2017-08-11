package com.pattern.demo8.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Created by jinx on 2017/8/11.
 */
public abstract class CarModel {
    private List<String> sequence = new ArrayList<>();
    protected abstract void start();
    protected abstract void alarm();
    protected abstract void engineBoom();
    protected abstract void stop();
    final public void run(){
        for (int i = 0; i <sequence.size(); i++) {
            String actionName  =sequence.get(i);
            if ("start".equalsIgnoreCase(actionName)){
                this.start();
            }if ("alarm".equalsIgnoreCase(actionName)){
                this.alarm();
            }if ("engineBoom".equalsIgnoreCase(actionName)){
                this.engineBoom();
            }if ("stop".equalsIgnoreCase(actionName)){
                this.stop();
            }
        }
    }

    public void setSequence(ArrayList<String> sequence){
        this.sequence = sequence;
    }

}
