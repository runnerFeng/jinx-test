package com.think.in.java.chapter16.demo1;

/**
 * Desc:
 * Created by jinx on 2017/2/6
 */
public class BerylliumSphere {
    private static long counter;
    private final long id = counter++;
    public String toString(){
        return "Sphere" + id;
    }


    public static void hide(BerylliumSphere[] berylliumSpheres){
        System.out.println(berylliumSpheres.length);
    }
    public static void main(String[] args) {
//        hide(new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()});
        BerylliumSphere[] berylliumSphere = {new BerylliumSphere(),new BerylliumSphere()};
        hide(berylliumSphere);
    }
}
