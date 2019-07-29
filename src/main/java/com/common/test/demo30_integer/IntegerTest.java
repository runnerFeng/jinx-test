package com.common.test.demo30_integer;

/**
 * @author jinx
 * @date 2018/08/27 22:03
 * Desc:
 */
public class IntegerTest {
    public static void main(String[] args) {
        // 1.使用new生成的integer对象永远不相等，因为是两个对象内存地址不相同
        System.out.println("--------1-----------");
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1.equals(i2));
        System.out.println(i1 == i2);

        // 2.int和integer比较时只要两个变量的值相等，则结果相等，因为integer会自动拆箱为int类型
        System.out.println("-------2------");
        Integer i3 = new Integer(1);
        int i4 = 1;
        System.out.println(i3 == i4);

        // 3.new 生成的integer对象的非new生成的integer对象比较时，结果为false。（因为非new生成的integer对象指向的是常量池中的对象，
        // 而new生成的变量指向的是堆中新建的对象，两者在内存中的地址不同）
        System.out.println("--------3----------");
        Integer i5 = new Integer(1);
        Integer i6 = 1;
        System.out.println(i5.equals(i6));
        System.out.println(i5 == i6);

        /**
         * 4.对于两个非new生成的对象进行比较时，如果两个变量的值区间在-128-127之间则比较结果为true,否则为false(在编译Integer i7 =
         *   1时，会翻译为：Integer i7 = Integer.valueOf(i7),而integer.valueOf源码为：{@link Integer#valueOf(int)}),所以对
         *   integer的值比较如果在-128-127之间用==比较时返回true但是超过这个范围返回结果为false,所以对int包装类型integer的值比较还
         *   是老老实实用equals方法进行比较靠谱*/
        System.out.println("----------4-----------");
        Integer i7 = 1;
        Integer i8 = 1;
        System.out.println(i7 == i8);
        Integer i9 = 128;
        Integer i10 = 128;
        System.out.println(i9 == i10);
    }
}
