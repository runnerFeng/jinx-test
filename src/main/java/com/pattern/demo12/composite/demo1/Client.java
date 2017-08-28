package com.pattern.demo12.composite.demo1;

import java.util.ArrayList;

/**
 * Desc:
 * Created by jinx on 2017/8/28.
 */
public class Client {
    public static void main(String[] args) {
        //首先产生了一个根节点
        Root ceo = new RootImpl("王大麻子", "总经理", 100000);
        //产生三个部门经理，也就是树枝节点
        Branch developDep = new BranchImpl("刘大瘸子", "研发部门经理", 10000);
        Branch salesDep = new BranchImpl("马二拐子", "销售部门经理", 20000);
        Branch financeDep = new BranchImpl("赵三驼子", "财务部经理", 30000);
        //再把三个小组长产生出来
        Branch firstDevGroup = new BranchImpl("杨三乜斜", "开发一组组长", 5000);
        Branch secondDevGroup = new BranchImpl("吴大棒槌", "开发二组组长", 6000);
        //剩下的及时我们这些小兵了,就是路人甲，路人乙
        Leaf a = new LeafImpl("a", "开发人员", 2000);
        Leaf b = new LeafImpl("b", "开发人员", 2000);
        Leaf c = new LeafImpl("c", "开发人员", 2000);
        Leaf d = new LeafImpl("d", "开发人员", 2000);
        Leaf e = new LeafImpl("e", "开发人员", 2000);
        Leaf f = new LeafImpl("f", "开发人员", 2000);
        Leaf g = new LeafImpl("g", "开发人员", 2000);
        Leaf h = new LeafImpl("h", "销售人员", 5000);
        Leaf i = new LeafImpl("i", "销售人员", 4000);
        Leaf j = new LeafImpl("j", "财务人员", 5000);
        Leaf k = new LeafImpl("k", "CEO秘书", 8000);
        Leaf zhengLaoLiu = new LeafImpl("郑老六", "研发部副总", 20000);
        //该产生的人都产生出来了，然后我们怎么组装这棵树
        //首先是定义总经理下有三个部门经理
        ceo.add(developDep);
        ceo.add(salesDep);
        ceo.add(financeDep);
        //总经理下还有一个秘书
        ceo.add(k);
        //定义研发部门 下的结构
        developDep.add(firstDevGroup);
        developDep.add(secondDevGroup);
        //研发部经理下还有一个副总
        developDep.add(zhengLaoLiu);
        //看看开发两个开发小组下有什么
        firstDevGroup.add(a);
        firstDevGroup.add(b);
        firstDevGroup.add(c);
        secondDevGroup.add(d);
        secondDevGroup.add(e);
        secondDevGroup.add(f);
        //再看销售部下的人员情况
        salesDep.add(h);
        salesDep.add(i);
        //最后一个财务
        financeDep.add(j);
        //树状结构写完毕，然后我们打印出来
        System.out.println(ceo.getInfo());
        //打印出来整个树形
        getAllSubordinateInfo(ceo.getSubordinateInfo());
    }

    //遍历所有的树枝节点，打印出信息
    private static void getAllSubordinateInfo(ArrayList subordinateList) {
        int length = subordinateList.size();
        for (int m = 0; m < length; m++) { //定义一个ArrayList长度，不要在for循环中每次计算
            Object s = subordinateList.get(m);
            if (s instanceof LeafImpl) { //是个叶子节点，也就是员工
                System.out.println(((LeafImpl) s).getInfo());
            } else {
                BranchImpl branch = (BranchImpl) s;
                System.out.println(branch.getInfo());
                //再递归调用
                getAllSubordinateInfo(branch.getSubordinateInfo());
            }
        }
    }

}
