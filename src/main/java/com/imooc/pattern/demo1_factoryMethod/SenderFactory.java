package com.imooc.pattern.demo1_factoryMethod;

/**
 * Desc:一天一种设计模式
 * Created by jinx on 2017/6/6.
 */
public class SenderFactory {

    //普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型！");
            return null;
        }
    }

    //多个工厂方法模式，是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。
    public Sender produceMail() {
        return new MailSender();
    }

    public Sender produceSms() {
        return new SmsSender();
    }

    //静态工厂方法模式，不需要创建实例，直接调用即可
    public static Sender produceMail2() {
        return new MailSender();
    }

    public static Sender produceSms2() {
        return new SmsSender();
    }
}
