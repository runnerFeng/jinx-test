package com.common.test.demo49_mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author: Aug
 * @Date: 2021-06-28 18:01
 * @Desc:
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper PERSON_MAPPER = Mappers.getMapper(PersonMapper.class);

    PersonVO personDO2VO(PersonDO personDO);
}
