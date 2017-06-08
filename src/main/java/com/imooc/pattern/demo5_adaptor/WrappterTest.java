package com.imooc.pattern.demo5_adaptor;

/**
 * Desc:接口适配器
 * Created by jinx on 2017/6/8.
 */
public class WrappterTest {
    public static void main(String[] args) {

        Sourceable sourceable1 = new SourceSub1();
        Sourceable sourceable2 = new SourceSub2();
        sourceable1.method1();
        sourceable1.method2();
        sourceable2.method1();
        sourceable2.method2();
    }
}
