package com.common.test.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author jinx
 * @Date 2022/6/23
 * @Desc 删除HashMap中的元素
 */
public class Test15 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put(null,4);
        map.put(null,5);
        map.put("d",null);
        map.put(null,null);
//        removeElement(map,"b");
        System.out.println(map);
    }

    public static void removeElement(Map<String ,Integer> map,String removeKey){
        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry = iterator.next();
            if (entry.getKey().equals(removeKey)){
                iterator.remove();
            }
        }
    }
}
