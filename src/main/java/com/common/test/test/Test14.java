package com.common.test.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jinx
 * @Date 2022/6/23
 * @Desc 删除ArrayList中的元素
 */
public class Test14 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(0,0);
        System.out.println(list);
        removeElement(list,2);
        System.out.println(list);
    }

    public static void removeElement(List<Integer> list,Integer element){
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            Integer next = iterator.next();
//            if (next.equals(element)){
//                iterator.remove();
//            }
//        }

        list.removeIf(next->next.equals(element));
    }
}
