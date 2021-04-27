package com.pattern.demo7_template;

/**
 * Desc:1.在重写了父类部分方法后，再调用从父类继承的方法，产生不同的结果（而这正是模板方法模式）
 * 2.模板方法模式是通过把不变行为搬移到父类（超类），去除了类中的重复代码来体现它的优势。模板方法模式就是提供了一个代码复用的平台。当遇到一系列步骤构成的过程需要执行，这个过程从高层次上看是相同的，但有些步骤的实现可能不同时就可以考虑使用模板方法模式。也就是说，当不变和可变的行为在方法的子类实现中混合在一起的时候，不变的行为就会在子类中重复出现。能过模板方法模式把这些行为搬移到单一的地方，这样就帮助子类摆脱重复的不变行为的纠缠。
 * 3.template使用继承实现
 * Created by jinx on 2017/8/11.
 */
public class Client {

    public static void main(String[] args) {
        HummerH1Model hummerModel1 = new HummerH1Model();
        hummerModel1.setAlarmFalg(false);
        hummerModel1.run();
        HummerModel hummerModel2 = new HummerH2Model();
        hummerModel2.run();
    }
}
