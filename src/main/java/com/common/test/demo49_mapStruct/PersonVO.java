package com.common.test.demo49_mapStruct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: Aug
 * @Date: 2021-06-28 17:57
 * @Desc:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonVO implements Serializable {

    private static final long serialVersionUID = 2711609831354341576L;

    private Long id;
    private String name;
    private String sex;
    private Integer age;
    private String address;
}
