package com.imooc.pattern.demo5_adaptor;

/**
 * Desc:接口适配器
 * 当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可。
 * Created by jinx on 2017/6/8.
 */
public abstract class Wrapper2 implements Sourceable {
    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}
