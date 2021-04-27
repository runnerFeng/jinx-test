package com.pattern.demo16_state.demo3;

/**
 * Desc:
 * Created by jinx on 2017/8/31.
 */
public class Context {
    public static final LiftState openingState = new OpeningState();
    public static final LiftState closingState = new ClosingState();
    public static final LiftState runningState = new RunningState();
    public static final LiftState stoppingState = new StoppingState();

    //因为执行具体行为的是实现类，所以此处引用父类执行具体的行为（多态）
    private LiftState liftState;

    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        //执行行为：具体的实现类执行行为
        this.liftState = liftState;
        //切换环境：给每个实现类传过去大环境，在具体方法中可以进行状态的切换
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }
}
