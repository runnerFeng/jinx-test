package com.common.test.demo19_generic;

/**
 * @author jinx
 * @date 2018/2/5 17:38
 * Desc:getGenericSuperclass测试
 */
public class TestUserService {
    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println(userService.getClazz());
    }
}
