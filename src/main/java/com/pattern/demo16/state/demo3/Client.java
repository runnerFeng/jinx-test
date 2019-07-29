package com.pattern.demo16.state.demo3;

/**
 * Desc:1.站在状态的角度去检查方法，一个状态下只能执行特定的行为
 * 2.所谓状态模式就是允许对象在内部状态发生改变时改变它的行为，对象看起来好像修改了它的类(状态改变时，context中的具体实现类也改了，即改变了他的类)；行为依赖于状态。
 * Created by jinx on 2017/8/31.
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
//        context.setLiftState(Context.runningState);
        //1.此种方式是：该状态下可以调用该方法，但是如果状态不对的情况下该方法中什么都不做(但是可以进入该方法体)；
        //2.还有一种方式是该状态下可以调用该方法，但是如果状态不对的情况下不能进入该方法体。
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
