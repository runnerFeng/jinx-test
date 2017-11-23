package com.commonTest.demo16;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Desc:
 * Created by jinx on 2017/10/11.
 */
public class Jackson {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    public static void main(String[] args) throws JsonProcessingException {
        User user = new User();
        user.setUsername("lf");
        user.setPassword("123");
        System.out.println(user.getGender());

        Address address = new Address();
        address.setProvince("甘肃");
        System.out.println(address.getCity());
        user.setAddress(address);

        School school = null;

        user.setSchool(school);


        System.out.println(objectMapper.writeValueAsString(user));

    }
}
