package com.commonTest.demo9_constructMethed;

/**
 * Desc:
 * Created by jinx on 2017/4/8.
 */
public class LiuFeng {
    private int id;
    private String name;
    private String gender;

    /**
     * 添加私有的构造方法可以阻止外部直接实例化该方法
     */
    private LiuFeng() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
