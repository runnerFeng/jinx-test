package com.pattern.demo7.template;

/**
 * Desc:template
 * Created by jinx on 2017/8/11.
 */
public class Client {

    public static void main(String[] args) {
        HummerH1Model hummerModel1 = new HummerH1Model();
        hummerModel1.setAlarmFalg(false);
        hummerModel1.run();
        HummerModel hummerModel2 = new HummerH2Model();
        hummerModel2.run();
    }
}
