package com.audition.demo6;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fans
 * @Date: 2021/9/15 22:14
 * @Desc: 移除ArrayList<Integer> x中的y
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(3);
        int y = 3;
        remove3(list,y);
        log.info("list:{}",list);
    }

    /**
     * 顺序移除的问题是，如果要移除的元素是连续的，那么第二个元素会移除失败，如果需要移除的元素没有连续则没问题
     * @param list
     * @param y
     * @return
     */
    private static List<Integer> remove1(ArrayList<Integer> list, int y) {
        for (int i = 0 ; i < list.size() ; i++) {
            if (list.get(i) == y){
                list.remove(i);
            }
        }
        return list;
    }

    /**
     * 倒叙移除，避免数组移动带来的连续的y中第二个y移除失败的问题
     * @param list
     * @param y
     * @return
     */
    private static List<Integer> remove2(ArrayList<Integer> list, int y) {
        for (int i = list.size()-1 ; i >=0 ; i--) {
            if (list.get(i) == y){
                list.remove(i);
            }
        }
        return list;
    }

    private static List<Integer> remove3(ArrayList<Integer> list, int y) {
        for(Integer i:list){
            if (i == y){
                list.remove(i);
            }
        }
        return list;
    }



}
