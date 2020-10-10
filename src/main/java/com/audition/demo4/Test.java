package com.audition.demo4;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Aug
 * @Date: 2020-10-09 22:02
 * @Desc: 获取该元素在链表中可能出现的位置
 */
public class Test {

    public static void main(String[] args) {
        Map map = new HashMap();

        List list = new ArrayList<>();
    }

//    public int[] indexOf(int t) {
//        Node n = head;
//        // 计算node的长度用以初始化数组大小
//        int m = 0;
//        for (int k = 0; n.next != null; k++) {
//            m++;
//        }
//
//        int[] arrays = new int[m];
//        int j = 0;
//        // 标记是否是否匹配到链表中的元素
//        int flag = 0;
//        for (int i = 0; n.next != null; i++) {
//            n = n.next;
//            if (n.item.equals(t)) {
//                arrays[j] = i;
//                flag = -1;
//                j++;
//            }
//        }
//        // 如果没有匹配到链表中的元素数组中只保存一个值-1
//        if (flag == 0) {
//            arrays[0] = -1;
//        }
//        return arrays;
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        if (tf1.getText.length() == 0) {
//            tf3.setText("请在第一栏中输入一个字符串");
//        } else {
//            int[] order = L.indexOf(tf1.getText());
//            if (order[0] != -1) {
//                // 遍历order中的元素进行拼接
//                String result = "";
//                for (int i = 0; i < order.length; i++) {
//                    int o = order[i];
//                    result += o + ",";
//                }
//                result = result.substring(0, order.length - 1);
//                tf3.setText("顺序表中出现该值的位置有:" + result);
//            } else {
//                tf3.setText("此顺序表中不包含值为" + tf1.getText() + "的数据元素");
//            }
//        }
//        tf1.setText("");
//        tf3.setText("");
//    }

}
