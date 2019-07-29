package com.common.test.demo23_util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/11/14 13:38
 */
public class AddressUtils {
    public static Logger logger = LoggerFactory.getLogger(AddressUtils.class);

    public static String getAddress(String ip) {
        try {
            String path = "http://int.dpool.sina.com.cn/iplookup/iplookup.php";
            JSONObject json = httpGet(path + "?format=json&ip=" + ip);
            if (null != json) {
                if ("1".equals(json.get("ret").toString())) {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(URLDecoder.decode(json.getString("province"), "utf-8"));// 省份
                    buffer.append(URLDecoder.decode(json.getString("city"), "utf-8"));// 市区
                    return buffer.toString();
                }
            }
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        return null;
    }

    public static JSONObject httpGet(String url) {
        JSONObject jsonResult = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(2000).setConnectTimeout(2000).build();
        request.setConfig(requestConfig);
        try {
            CloseableHttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                String strResult = EntityUtils.toString(entity, "utf-8");

                if (strResult.indexOf("ret") == -1) {
                    strResult = "{\"ret\":-1}";
                }

                jsonResult = JSONObject.parseObject(strResult);
            } else {
                logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            logger.error("get请求提交失败:" + url, e);
        } finally {
            request.releaseConnection();
        }
        return jsonResult;
    }
}
