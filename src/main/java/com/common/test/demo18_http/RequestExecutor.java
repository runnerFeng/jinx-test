package com.common.test.demo18_http;

import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

/**
 * http请求执行器
 *
 * @param <T> 返回值类型
 * @param <E> 请求参数类型
 */
public interface RequestExecutor<T, E> {

    /**
     * @param httpclient 传入的httpClient
     * @param httpProxy  http代理对象，如果没有配置代理则为空
     * @param uri        uri
     * @param data       数据
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public T execute(CloseableHttpClient httpclient, HttpHost httpProxy, String uri, E data) throws ClientProtocolException, IOException;

}
