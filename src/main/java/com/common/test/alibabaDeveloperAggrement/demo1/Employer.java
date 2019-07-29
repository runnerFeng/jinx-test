package com.common.test.alibabaDeveloperAggrement.demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jinx
 * @date 2018/06/21 07:19
 * Desc:Collections.sort()方法实现方式
 */
public class Employer {
    private Integer age;

    public Employer(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {
        List<Employer> list = new ArrayList<>();
        list.add(new Employer(2));
        list.add(new Employer(1));
        list.add(new Employer(3));
        list.add(new Employer(4));

        //这种方式直接调用两个参数的sort方法
        Collections.sort(list, new Comparator<Employer>() {
            @Override
            public int compare(Employer o1, Employer o2) {
                return o1.getAge() > o2.getAge() ? 1 : -1;
            }
        });
        for (Employer employer : list) {
            System.out.println(employer.getAge());
        }
    }

    //这种定义方式要实现comparable<Employer>接口
//    @Override
//    public int compareTo(Employer o) {
//        return this.age.compareTo(o.age);
//    }
}
