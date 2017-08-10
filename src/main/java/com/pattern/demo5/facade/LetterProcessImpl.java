package com.pattern.demo5.facade;

/**
 * Desc:
 * Created by jinx on 2017/8/10.
 */
public class LetterProcessImpl implements LetterProcess {
    @Override
    public void writeContext(String context) {
        System.out.println("填写信的内容：" + context);
    }

    @Override
    public void fillEvelope(String address) {
        System.out.println("填写收件人姓名地址：" + address);
    }

    @Override
    public void letterIntoEvelope() {
        System.out.println("把信放进信封。");
    }

    @Override
    public void sendLetter() {
        System.out.println("邮递信件。");
    }
}
