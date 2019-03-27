package com.audition.demo2;

/**
 * @author jinx
 * @date 2019/3/27 15:59
 * Desc:
 */
public class SynBlockMethod {
    public void testA(){
        synchronized (new Object()){
            System.out.println("测试同步代码块编译后的字节码");
        }
    }
}
