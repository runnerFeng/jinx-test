package com.pattern.demo17_prototype.demo1;

import java.util.Random;

/**
 * Desc:
 * Created by jinx on 2017/9/3.
 */
public class Client {
    /**
     * 发送邮件总数，数据库中取得
     */
    private static int MAX_COUNT = 6;

    public static void main(String[] args) {
        //模拟发送邮件
        int i = 0;
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("xxx银行版权所有。");
        while (i < MAX_COUNT) {
            mail.setAppellation(getRandomString(5) + "先生（女士）");
            mail.setReceiver(getRandomString(5) + "@" + getRandomString(8) + ".com");
            sendMail(mail);
            i++;
        }
    }

    private static void sendMail(Mail mail) {
        System.out.println("标题：" + mail.getSubject() + "\t收件人：" + mail.getReceiver() + "\t...发送成功！");
    }

    private static String getRandomString(int maxLength) {
        String source = "abcdefghijklmnopqrskuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random rand = new Random();
        for (int i = 0; i < maxLength; i++) {
            sb.append(source.charAt(rand.nextInt(source.length())));
        }
        return sb.toString();
    }
}
