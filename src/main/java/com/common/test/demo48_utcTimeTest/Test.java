package com.common.test.demo48_utcTimeTest;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Author: Aug
 * @Date: 2021-06-18 10:44
 * @Desc:
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        String s = String.valueOf(System.currentTimeMillis());
        Date date = DateUtil.parseUTC(s);
        log.info("date:{}",date);
    }

}
