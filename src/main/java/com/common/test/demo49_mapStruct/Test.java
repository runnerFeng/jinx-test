package com.common.test.demo49_mapStruct;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-06-28 18:04
 * @Desc:
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        PersonDO personDO = PersonDO.builder().personId(1L).address("sh").age(17).sex(1).name("fans").build();
        PersonVO personVO = PersonMapper.PERSON_MAPPER.personDO2VO(personDO);
        log.info("personVO:{}",personVO);
    }

}
