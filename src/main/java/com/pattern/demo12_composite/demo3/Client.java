package com.pattern.demo12_composite.demo3;

import java.util.ArrayList;

/**
 * Desc:上面我们讲到的就是组合模式（也叫合成模式），有时又叫做部分－整体模式（Part-Whole），主要是用来描述整体与部分的关系，用的最多的地方就是树形结构。
 * 第一个优点只要是树形结构，就要考虑使用组合模式，这个一定记住，只要是要体现局部和整体的关系的时候，而且这种关系还可能比较深，考虑一下组合模式吧。
 * Created by jinx on 2017/8/28.
 */
public class Client {
    public static void main(String[] args) {
        //首先是组装一个组织结构出来
        BranchImpl ceo = compositeCorpTree();
        //首先把CEO的信息打印出来：
        System.out.println(ceo.getInfo());
        //然后是所有员工信息
        System.out.println(getTreeInfo(ceo));
    }

    public static BranchImpl compositeCorpTree() {
        //首先产生总经理CEO
        BranchImpl root = new BranchImpl("王大麻子", "总经理", 100000);

        //把三个部门经理产生出来
        BranchImpl developDep = new BranchImpl("刘大瘸子", "研发部门经理", 10000);
        BranchImpl salesDep = new BranchImpl("马二拐子", "销售部门经理", 20000);
        BranchImpl financeDep = new BranchImpl("赵三驼子", "财务部经理", 30000);

        //再把三个小组长产生出来
        BranchImpl firstDevGroup = new BranchImpl("杨三乜斜", "开发一组组长", 5000);
        BranchImpl secondDevGroup = new BranchImpl("吴大棒槌", "开发二组组长", 6000);

        //把所有的小兵都产生出来
        LeafImpl a = new LeafImpl("a", "开发人员", 2000);
        LeafImpl b = new LeafImpl("b", "开发人员", 2000);
        LeafImpl c = new LeafImpl("c", "开发人员", 2000);
        LeafImpl d = new LeafImpl("d", "开发人员", 2000);
        LeafImpl e = new LeafImpl("e", "开发人员", 2000);
        LeafImpl f = new LeafImpl("f", "开发人员", 2000);
        LeafImpl g = new LeafImpl("g", "开发人员", 2000);
        LeafImpl h = new LeafImpl("h", "销售人员", 5000);
        LeafImpl i = new LeafImpl("i", "销售人员", 4000);
        LeafImpl j = new LeafImpl("j", "财务人员", 5000);
        LeafImpl k = new LeafImpl("k", "CEO秘书", 8000);
        LeafImpl zhengLaoLiu = new LeafImpl("郑老六", "研发部副经理", 20000);

        //开始组装
        //CEO下有三个部门经理和一个秘书
        root.addSubordinate(k);
        root.addSubordinate(developDep);
        root.addSubordinate(salesDep);
        root.addSubordinate(financeDep);

        //研发部经理
        developDep.addSubordinate(zhengLaoLiu);
        developDep.addSubordinate(firstDevGroup);
        developDep.addSubordinate(secondDevGroup);

        //看看开发两个开发小组下有什么
        firstDevGroup.addSubordinate(a);
        firstDevGroup.addSubordinate(b);
        firstDevGroup.addSubordinate(c);
        secondDevGroup.addSubordinate(d);
        secondDevGroup.addSubordinate(e);
        secondDevGroup.addSubordinate(f);

        //再看销售部下的人员情况
        salesDep.addSubordinate(h);
        salesDep.addSubordinate(i);
        //最后一个财务
        financeDep.addSubordinate(j);
        return root;
    }

    //遍历整棵树,只要给我根节点，我就能遍历出所有的节点
    public static String getTreeInfo(BranchImpl root) {
        ArrayList<Corp> subordinateList = root.getSubordinate();
        String info = "";
        for (Corp s : subordinateList) {
            if (s instanceof LeafImpl) { //是员工就直接获得信息
                info = info + s.getInfo() + "\n";
            } else { //是个小头目
                info = info + s.getInfo() + "\n" + getTreeInfo((BranchImpl) s);
            }
        }
        return info;
    }
}
