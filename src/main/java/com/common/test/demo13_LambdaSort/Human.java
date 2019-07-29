package com.common.test.demo13_LambdaSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Desc:
 * Created by jinx on 2017/6/15.
 */
public class Human {
    private String name;
    private int age;


    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Human human1 = new Human("a", 3);
        Human human2 = new Human("b", 2);
        Human human3 = new Human("c", 1);
        List<Human> list = new ArrayList<>();
        list.add(human1);
        list.add(human2);
        list.add(human3);

        for (Human human : list) {
            System.out.println(human.getName());
        }

        System.out.println("------------------------");
        Comparator<Human> comparator = (h1, h2) -> Integer.compare(h1.getAge(), h2.getAge());
//        list.sort(comparator);
        list.sort(comparator.reversed());
        for (Human human : list) {
            System.out.println(human.getName());
        }

        System.out.println("------------------------");
//        Comparator<Human> comparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
//        //正序
//        list.sort(comparator);
//        //倒序
////      list.sort(comparator.reversed());
//        for (Human human : list) {
//            System.out.println(human.getName());
//        }
    }

}
