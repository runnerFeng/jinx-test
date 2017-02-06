package com.commonTest;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Desc:FileUtils用法
 * Created by lf on 2017/1/25
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String path = Thread.currentThread().getContextClassLoader().getResource("spring/spring.conf").getFile();
        System.out.println(path);
        System.out.println(FileUtils.readFileToString((new File(path)), "utf-8"));
    }

}

