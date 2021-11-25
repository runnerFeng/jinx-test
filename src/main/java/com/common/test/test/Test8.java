package com.common.test.test;

import com.common.test.demo52_java8filter.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @Author jinx
 * @Date 2021/11/12
 * @Desc
 */
@Slf4j
public class Test8 {
    public static void main(String[] args) {
        int sequence = 1;
        List<Student> list = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            Student student = new Student(i+"name",sequence);
            list.add(student);
            log.info("sequence:{}",sequence++);
        }

        // sort by sequence and let name = 1 in first position;

    }
}
