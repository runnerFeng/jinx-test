package com.common.test.demo27_readFileData;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;


/**
 * @author jinx
 * @date 2018/5/14 16:30
 * Desc:google guava了解下
 */
public class Test {
    public static void main(String[] args) throws IOException {
        for (String line : Files.readLines(new File("f:\\data.txt"), Charsets.UTF_8)) {
            System.out.println(line);
        }
    }
}
