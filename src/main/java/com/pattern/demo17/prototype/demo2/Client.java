package com.pattern.demo17.prototype.demo2;


import java.util.Random;

/**
 * Desc:原型模式适合在什么场景使用？一是类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等；
 * 二是通过 new 产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式；
 * 三是一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用。
 * 在实际项目中，原型模式很少单独出现，一般是和工厂方法模式一起出现，通过 clone 的方法创建一个对象，然后由工厂方法提供给调用者。
 * Created by jinx on 2017/9/3.
 */
public class Client {
    //发送邮件总数，数据库中取得
    private static int MAX_COUNT = 6;

    public static void main(String[] args) {
        //模拟发送邮件
        int i = 0;
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("xxx银行版权所有。");
        while (i < MAX_COUNT) {
            Mail cloneMail = mail.clone();
            cloneMail.setAppellation(getRandomString(5) + "先生（女士）");
            cloneMail.setReceiver(getRandomString(5) + "@" + getRandomString(8) + ".com");
            sendMail(cloneMail);
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
