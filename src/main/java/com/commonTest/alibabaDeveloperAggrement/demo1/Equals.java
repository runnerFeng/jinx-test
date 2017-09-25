package com.commonTest.alibabaDeveloperAggrement.demo1;

/**
 * Desc:equals test
 * Created by jinx on 2017/5/15.
 */
public class Equals {
    public static void main(String[] args) {
        //调用equals方法时，常量放在前面避免npe异常
        //String的equals方法首先比较
        String s = null;
        String s0 = "aa";
        if (s0.equals(s))
//        if (s.equals(s0))
        {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        System.out.println("s s0------------------------------");


        String s1 = "a1";
        String s2 = "a1";
        String s3 = "a" + "1";
        String s4 = "a" + 1;
        String s5 = "a" + Integer.parseInt("1");
        int i = 1;
        String s6 = "a" + i;
        System.out.println(s1 == s2);
        //根据源码首先判断是否是同一个对象（地址判断），如果是直接返回true，否则接着判断是否是String的实例，如果是，接着判断字符串长度是否相等，如果相等在接着判断每个字符是否相等
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);//常量运算，值确定
        System.out.println(s1 == s4);//同上
        System.out.println(s1 == s5);//false 有点难以理解吧，这不跟上面一样吗？还真不一样，因为调用方法后的值只有在运行后才能确定
        System.out.println(s1 == s6);//同上
        System.out.println("s1~s6------------------------------");

        //equal方法永远是值比较，他不在乎内存地址。
        //根据源码基本数据类型的equals方法首先比较是不是该类型，在比较值是否相等。
        Integer i1 = -128;
        Integer i2 = -128;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        System.out.println("i1 i2------------------------------");

        Integer i3 = -129;
        Integer i4 = -129;
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));
        System.out.println("i3 i4------------------------------");

        //3 只要是new出来的对象其内存地址一定是不等的(此时不用考虑常量池范围)，所以==比较为false
        //Integer i5 = new Integer(-129);
        //Integer i6 = new Integer(-129);
        Integer i5 = new Integer(-128);
        Integer i6 = new Integer(-128);
        System.out.println(i5 == i6);
        System.out.println(i5.equals(i6));
        System.out.println("i5 i6------------------------------");

        Integer i7 = -129;
        Integer i8 = new Integer(-129);
        System.out.println(i7 == i8);
        System.out.println(i7.equals(i8));
        System.out.println("i7 i8------------------------------");


        Integer i9 = 1;
        Integer i10 = Integer.valueOf(1);
        //valueOf()方法根据源码首先判断参数范围，如果超出-128~127则在堆上实例化一个新的对象，否则取IntegerCache中共享的对象
        System.out.println(i9 == i10);
        System.out.println(i9.equals(i10));
        System.out.println("i9 i10------------------------------");

        Integer i11 = 128;
        Integer i12 = Integer.valueOf(128);
        System.out.println(i11 == i12);
        System.out.println(i11.equals(i12));
        //所以对于Integer的值比较推荐用equals方法，防止用==比较是掉进IntegerCache的坑中
        System.out.println("i11 i12------------------------------");

        //根据源码对象的equals方法是对地址的比较
        User u1 = new User();
        User u2 = new User();
        System.out.println(u1 == u2);
        System.out.println(u1.equals(u2));
        System.out.println("u1 u2------------------------------");

    }
}
