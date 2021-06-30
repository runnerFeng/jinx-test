package com.common.test.demo49_mapStruct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: Aug
 * @Date: 2021-06-28 17:51
 * @Desc:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDO implements Serializable {

    private static final long serialVersionUID = 6363865313251666304L;

    private Long personId;
    private String name;
    private Integer sex;
    private Integer age;
    private String address;
}
