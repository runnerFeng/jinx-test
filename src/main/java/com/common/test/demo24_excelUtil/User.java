package com.common.test.demo24_excelUtil;

import lombok.Data;

/**
 * @author jinx
 * @date 2018/03/01 22:36
 * Desc:
 */
@Data
public class User {
    private String username;
    private String password;
    private String gender;

    public User(String username, String password, String gender) {
        this.username = username;
        this.password = password;
        this.gender = gender;
    }
}
