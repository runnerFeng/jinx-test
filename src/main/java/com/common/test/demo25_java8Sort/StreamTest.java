package com.common.test.demo25_java8Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jinx
 * @Date: 2019-07-23 14:40
 * @Desc:stream()和parallelStream()在不同数量级时效率测试,parallelStream有outOfMemory风险,请注意
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        Long end1 = System.currentTimeMillis()-start1;
        System.out.println("end1:"+end1+",cpu:"+Runtime.getRuntime().availableProcessors());

        Long start2 = System.currentTimeMillis();
        int result2 = list.stream().mapToInt(Integer::intValue).sum();
        Long end2 = System.currentTimeMillis()-start2;
        System.out.println("end2:"+end2+",result:"+result2);

        Long start3 = System.currentTimeMillis();
        int result3 = list.parallelStream().mapToInt(Integer::intValue).sum();
        Long end3 = System.currentTimeMillis()-start3;
        System.out.println("end3:"+end3+",result3:"+result3);
    }
}
