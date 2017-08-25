package com.pattern.demo8.builder;

/**
 * Desc:
 * Created by jinx on 2017/8/14.
 */
public class Client {
    public static void main(String[] args) {
        //1.原始操作方式,不能满足多远需求
//        BenzModel benzModel = new BenzModel();
//        List<String> sequence = new ArrayList<>();
//        sequence.add("engineBoom");
//        sequence.add("start");
//        sequence.add("stop");
//        benzModel.setSequence(sequence);
//        benzModel.run();

        //2.可以满足多远需求，但分工不明确，交给客户端责任太多
        // 首先定义一个顺序
//        List<String> sequenceList = new ArrayList<>();
//        sequenceList.add("engineBoom");
//        sequenceList.add("start");
//        sequenceList.add("stop");
//
//        //2.2生产奔驰
//        BenzBuilder benzBuilder = new BenzBuilder();
//        benzBuilder.setSetSequence(sequenceList);
//        BenzModel benzModel = (BenzModel) benzBuilder.getCarModel();
//        benzModel.run();
//
//        //2.2生产同样顺序的宝马、
//        BMWBuilder bmwBuilder = new BMWBuilder();
//        bmwBuilder.setSetSequence(sequenceList);
//        BMWModel bmwModel = (BMWModel) bmwBuilder.getCarModel();
//        bmwModel.run();

        //3.此时，客户端只需选择满足自己需求的方案就行了、
        //生产一万辆A型奔驰。。。
        Direct direct = new Direct();
        for (int i = 0; i < 10000; i++) {
            direct.getABenzModel().run();
            direct.getBBenzModel().run();
        }
        //生产1000辆B型宝马。。。
        for (int i = 0; i < 100; i++) {
            direct.getBBMWModel().run();
        }
    }
}
