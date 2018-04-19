package com.pattern.demo5.facade;

/**
 * Desc:1.门面模式:直接调用门面的方法就可以了，不用了解具体的实现方法以及相关的业务顺序,一个子系统比较复杂的实话，比如算法或者业务比较复杂，就可以封装出一个或多个门面出来，项目的结构简单，而且扩展性非常好
 *      2.金玉其外，败絮其中
 *      3.使用接口组合实现
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
