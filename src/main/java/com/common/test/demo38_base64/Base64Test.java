package com.common.test.demo38_base64;

import cn.hutool.core.codec.Base64Encoder;
import org.springframework.util.Base64Utils;

/**
 * @Author: fans
 * @Date: 2019/12/1 13:18
 * @Desc:该测试类主要为了测试hutool工具base64的bug
 */
public class Base64Test {
    public static void main(String[] args) {
        // hutool base64
        String s = "今天上海降温了";
        System.out.println(Base64Encoder.encode(s));
        // spring base64
        System.out.println(Base64Utils.encode(s.getBytes()));
    }

}
