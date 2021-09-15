package com.common.test.demo0_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: jinx
 * @Date: 2019/9/4 23:11
 * @Desc:报表系统选择数据结构不当引发的测试案例：如果后续程序需要从容器中遍历取出之前保存好的数据则多用map保存数据，少用list保存数据
 * eg.报表系统中初始化8万个用户保存在map中，每个用户有11个币种，数据结构为Map<userId,List<UserDto>>，后续遍历每个用户的币种dto时，会消耗
 * 大概16ms的时间，如果有一万条记录则是160s,如果采用map结构Map<uesrId,Map<userId+currency>>则后续遍历每个用户币种时耗时几乎为零，效率提升
 * 10000*16倍
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            list.add(i);
        }

        Long startTime1 = System.currentTimeMillis();
        List<Integer> result1 = list.stream().filter(a -> a.intValue() == 11).collect(Collectors.toList());
        System.out.println(result1);
        Long endTime1 = System.currentTimeMillis();
        // cost 40ms
        System.out.println("costTime1:" + (endTime1 - startTime1));

        System.out.println("---------------------------------------");

        Map<Integer, Object> map = new HashMap<>();
        for (int i = 1; i <= 11; i++) {
            map.put(i, i);
        }
        Long startTime2 = System.currentTimeMillis();
        Object result2 = map.get(11);
        System.out.println(result2);
        Long endTime2 = System.currentTimeMillis();
        // cost 0ms
        System.out.println("costTime2:" + (endTime2 - startTime2));
    }
}
