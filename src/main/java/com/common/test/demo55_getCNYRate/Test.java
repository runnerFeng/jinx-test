package com.common.test.demo55_getCNYRate;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.github.fartherp.framework.common.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author jinx
 * @Date 2022/4/2
 * @Desc
 */
@Slf4j
public class Test {

    private static final String URL = "https://www.chinamoney.com.cn/r/cms/www/chinamoney/data/fx/ccpr.json?t=";

    public static void main(String[] args) {
       String dateStr = DateUtil.format( DateUtil.yesterday(), DatePattern.NORM_DATE_PATTERN);
        long date = DateUtil.offsetDay(DateUtil.yesterday(),-1).getTime();
//        String url = URL;
//        String url = URL+date*1000;
        String url = URL+1648719613000L;
        String json = HttpUtil.get(url, CharsetUtil.CHARSET_UTF_8);
        log.info("json:{}", json);
        RateResponse response = JsonUtil.fromJson(json, RateResponse.class);
        log.info("response:{}", JSONUtil.toJsonStr(response));
        log.info("date:{}",response.getData().getLastDate());
    }


}
