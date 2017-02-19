package com.commonTest.demo2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Desc:
 * Created by lf on 2017/2/16
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Student st1 = new Student();
        st1.setId(5237);
        st1.setName("liufeng");
        st1.setBirthDay(new Date());

        Student st2 = new Student();
        st2.setId(5117);
        st2.setName("saiya");
        st2.setBirthDay(new Date());
//ListConvertToJSon
        ObjectMapper mapper = new ObjectMapper();
        List<Student> studentList = new ArrayList<Student>();
studentList.add(st1);
studentList.add(st2);
        String jsonString = mapper.writeValueAsString(studentList);
        System.out.println(jsonString);
        //JsonConvertToList
        List<Student> studentList1 = mapper.readValue(jsonString,List.class);
        System.out.println(studentList1);
//
        Student[] strArr = {st1,st2};
        String jsonFromArr = mapper.writeValueAsString(strArr);
        System.out.println(jsonFromArr);
        Student[] stuArr = mapper.readValue(jsonFromArr,Student[].class);
        System.out.println(stuArr);
        System.out.println(mapper.readValue(jsonFromArr, new TypeReference<List<Student>>() {}));



    }
}
