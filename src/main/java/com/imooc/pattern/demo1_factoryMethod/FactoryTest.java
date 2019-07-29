package com.imooc.pattern.demo1_factoryMethod;

/**
 * Desc:
 * Created by jinx on 2017/6/6.
 */
public class FactoryTest {
    public static void main(String[] args) {
        SenderFactory senderFactory = new SenderFactory();
        //普通工厂方法模式
        Sender sender = senderFactory.produce("sms");
        sender.sender();
        //多个工厂方法模式
        Sender sender1 = senderFactory.produceMail();
        sender1.sender();
        //静态工厂模式
        Sender sender2 = SenderFactory.produceMail2();
        sender2.sender();
        //抽象工厂模式
        Provider provider = new MailSenderFactory();
        Sender sender3 = provider.produce();
        sender3.sender();
    }
}
