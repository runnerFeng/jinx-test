package com.common.test.alibabaDeveloperAggrement.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jinx
 * @date 2018/02/08 23:54
 * Desc:HashMap迭代
 */
public class HashMapIteratorTest {
    public static void main(String[] args) {
        Map map = new HashMap<Integer,String>();
        for (int i = 0; i < 1000000; i++) {
            map.put(i,"value:"+i);
        }

        long startTime  =System.currentTimeMillis();
        System.out.println("startTime:"+startTime);

        //返回value
//        for (Object o : map.values()) {
//            System.out.println(o);
//        }
        //返回key
//        for (Object o : map.keySet()) {
//            System.out.println(map.get(o));
//        }
        //返回key-value
//        for (Object o : map.entrySet()) {
//            System.out.println(o);
//        }

        //返回key-value 在foreach中不能add/remove元素否则报错，但是在iterator中可以remove元素
//       Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Integer,String> next =  iterator.next();
//            if (next.getKey() == 100) {
//                iterator.remove();
//            }
//                System.out.println(next);
//        }

        map.forEach((key,value)->{
            System.out.println(key+":"+value);
        });

        System.out.println("spendTime:"+(System.currentTimeMillis()-startTime));
    }
}
