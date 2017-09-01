package com.pattern.demo16.state.demo3;

/**
 * Desc:
 * Created by jinx on 2017/8/31.
 */
public abstract class LiftState {

    //以为此处需要在执行具体的行为是进行状态的切换所以引入context(context其实是一个包含了每种状态的一个大环境，只有在这个大环境中才可以进行状态的切换，起到连接每个状态的作用)
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();

    public abstract void close();

    public abstract void run();

    public abstract void stop();


}
