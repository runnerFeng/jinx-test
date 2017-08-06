package com.commonTest.demo5_jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Desc:
 * Created by jinx on 2017/7/10.
 */
public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setUsername("liufeng");
        user.setPassword("123456");
    }
}
