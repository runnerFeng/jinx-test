package com.audition.demo5;

import lombok.Data;

import java.util.List;

/**
 * @Author: fans
 * @Date: 2020/12/9 02:04
 * @Desc:
 */
@Data
public class Group {
    private String groupName;
    private List<Person> persons;
}
