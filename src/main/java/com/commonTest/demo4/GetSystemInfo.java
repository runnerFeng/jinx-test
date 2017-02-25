package com.commonTest.demo4;

import java.util.Properties;

/**
 * Desc:
 * Created by lf on 2017/2/22
 */
public class GetSystemInfo {
    public static void main(String[] args) {
        Properties props=System.getProperties(); //获得系统属性集
       String osName = props.getProperty("os.name"); //操作系统名称
        String osArch = props.getProperty("os.arch"); //操作系统构架
        String osVersion = props.getProperty("os.version"); //操作系统版本
        System.out.println(osName+osVersion);
    }
}
