package com.common.test.demo1_fileUtils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

/**
 * Desc:FileUtils用法
 * Created by lf on 2017/1/25
 */
public class FileUtilsTest {
    public static void main(String[] args) throws IOException {
        //获取当前配置文件的路径
        String path = Thread.currentThread().getContextClassLoader().getResource("spring/spring.conf").getFile();
        System.out.println(path);

        //获取当前配置文件的编译根目录
        String path1 = Thread.currentThread().getContextClassLoader().getResource(".").getPath();
        System.out.println(path1);

        //输出每行内容（返回值是String类型，自动换行）
        System.out.println(FileUtils.readFileToString((new File(path)), "utf-8"));

        //返回List集合，遍历输出
        List<String> list = FileUtils.readLines(new File(path));
        for (String s : list) {
            System.out.println(s);
        }
        //内部迭代器来枚举
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        //java8遍历。。。
        list.forEach((s -> System.out.println(s)));
        //java8极简版。。。

        list.forEach(System.out::println);


    }

}

