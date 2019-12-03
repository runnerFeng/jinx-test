package com.javaGuide.java.basic.demo3;

import lombok.Data;

/**
 * @Author: fans
 * @Date: 2019/12/3 23:34
 * @Desc:
 */
@Data
public class Test1 {
    private String username;
    private String password;

    public Test1(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
