package com.common.test.demo25_java8Sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

/**
 * @author jinx
 * @date 2018/9/6 11:29
 * Desc:
 */
public class SortTest {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        Apple apple1 = new Apple("1", "fendo1", new BigDecimal(10), (long) 10, 1);
        Apple apple2 = new Apple("2", "fendo2", new BigDecimal(20), (long) 20, 2);
        Apple apple3 = new Apple("3", "fendo3", new BigDecimal(30), (long) 10, 3);
        Apple apple4 = new Apple("4", "fendo4", new BigDecimal(40), (long) 40, 2);
        Apple apple5 = new Apple("5", "fendo5", new BigDecimal(50), (long) 30, 2);
        Apple apple6 = new Apple("6", "fendo6", new BigDecimal(60), (long) 60, 3);
        appleList.add(apple1);
        appleList.add(apple2);
        appleList.add(apple3);
        appleList.add(apple4);
        appleList.add(apple5);
        appleList.add(apple6);

        System.out.println("----------根据type分组--------------");
        Map<Integer, List<Apple>> map = appleList.stream().collect(Collectors.groupingBy(Apple::getType));
        for (Map.Entry<Integer, List<Apple>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("----------根据type分组,根据count统计-------------");
        Map<Integer, LongSummaryStatistics> map1 = appleList.stream().collect(Collectors.groupingBy(Apple::getType, Collectors.summarizingLong(Apple::getCount)));
        for (Map.Entry<Integer, LongSummaryStatistics> entry : map1.entrySet()) {
            LongSummaryStatistics statistics = entry.getValue();
            System.out.println(statistics);
        }

        System.out.println("-----------根据type分组，根据count再分组-------------");
        Map<Integer, Map<Long, List<Apple>>> map2 = appleList.stream().collect(Collectors.groupingBy(Apple::getType, Collectors.groupingBy(Apple::getCount)));
        for (Map.Entry<Integer, Map<Long, List<Apple>>> entry : map2.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("-----------------");
//        Map<Integer, Map<Long, List<Apple>>> map3 = appleList.stream().collect(Collectors.groupingBy(Apple::getType));
        System.out.println("-----------根据type分组，再统计------------");
        Map<Integer, Long> map3 = appleList.stream().collect(Collectors.groupingBy(Apple::getType, counting()));
        map3.forEach((key, value) -> System.out.println(key + ":" + value));

        System.out.println("------BigDecimal累加-----------------");
        BigDecimal sum = appleList.stream().map(Apple::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);
    }
}
