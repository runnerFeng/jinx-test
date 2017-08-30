package com.pattern.demo14.chainOfResponsibility.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/29.
 */
public abstract class Hander {
    //处理级别
    private int level;
    private Hander nextHander;

    //抽象类的构造方法的一个作用就是让具体子类传自己的参数上来，然后让父类来干活
    public Hander(int level) {
        this.level = level;
    }

    public final void handleMesage(IWomen women) {
        if (women.getTyp() == this.level) {
            //java多态的体现，此时是子类调用该方法所以该类中的this指具体的子类，父类负责请求的传递，子类方负责实现
            this.response(women);
        } else {
            if (this.nextHander != null) {
                this.nextHander.handleMesage(women);
                return;
            } else {
                System.out.println("没人处理了");
            }
        }
    }

    public void setNextHander(Hander nextHander) {
        this.nextHander = nextHander;
    }

    //抽象方法子类必须实现
    public abstract void response(IWomen women);
}
