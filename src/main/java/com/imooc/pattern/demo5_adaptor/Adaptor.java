package com.imooc.pattern.demo5_adaptor;

/**
 * Desc:类适配器
 * 当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可
 * Created by jinx on 2017/6/8.
 */
public class Adaptor extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is targetable method!");
    }
}
