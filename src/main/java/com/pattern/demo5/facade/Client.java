package com.pattern.demo5.facade;

/**
 * Desc:门面模式
 * Created by jinx on 2017/8/10.
 */
public class Client {
    public static void main(String[] args) {
        //原始调用方法
//        LetterProcess letterProcess = new LetterProcessImpl();
//        letterProcess.writeContext("hello ,it`s me ,do you know who i am?");
//        letterProcess.fillEvelope("Happy Road No 666");
//        letterProcess.letterIntoEvelope();
//        letterProcess.sendLetter();
        //门面模式调用
        ModenPostOffice modenPostOffice = new ModenPostOffice();
        modenPostOffice.sendLetter("hello rose,i`m jack!", "Happy Road No 666");

    }
}
