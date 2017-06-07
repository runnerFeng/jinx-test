package com.imooc.pattern.demo3_builder;

import com.imooc.pattern.demo1_factoryMethod.MailSender;
import com.imooc.pattern.demo1_factoryMethod.Sender;
import com.imooc.pattern.demo1_factoryMethod.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Created by jinx on 2017/6/7.
 */
public class Builder {
    private List<Sender> senderList = new ArrayList<Sender>();

    public void produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            senderList.add(new MailSender());
        }
    }

    public void produceSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            senderList.add(new SmsSender());
        }
    }

}
