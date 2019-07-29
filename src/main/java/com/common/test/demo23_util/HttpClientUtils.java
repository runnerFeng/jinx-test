package com.common.test.demo23_util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;

import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lvxy on 2017/2/26.
 */
public class HttpClientUtils {
    private static Logger logger = (Logger) LogManager.getLogger(HttpClientUtils.class);

    private static final String CHARSET = "UTF-8";


    private static int MAX_PER_ROUTE = 100;
    private static int MAX_TOTAL = 200;
    private static int SO_TIMEOUT = 10000;
    private static int CONNECTION_TIMEOUT = 10000;
    private static int TIME_OUT = 5000; //5000毫秒
    private static RequestConfig requestConfig = RequestConfig
            .custom()
            .setSocketTimeout(SO_TIMEOUT)
            .setConnectTimeout(CONNECTION_TIMEOUT).build();

    private static CloseableHttpClient httpClient = null;


    static {
        httpClient = initHttpClient();
    }


    private static CloseableHttpClient initHttpClient() {

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        // Increase max total connection to 200
        cm.setMaxTotal(MAX_TOTAL);
        // Increase default max connection per route to 20
        cm.setDefaultMaxPerRoute(MAX_PER_ROUTE);
        // Increase max connections for localhost:80 to 50

        SSLConnectionSocketFactory sslConnectionSocketFactory = getSSLConnectionSocketFactory();

        HttpClientBuilder httpClientBuilder = HttpClients
                .custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(requestConfig)
                .setRetryHandler(new DefaultHttpRequestRetryHandler())
                .setConnectionReuseStrategy(new DefaultConnectionReuseStrategy())
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());
        if (sslConnectionSocketFactory != null) {
            httpClientBuilder.setSSLSocketFactory(sslConnectionSocketFactory);
        }
        return httpClientBuilder.build();

    }


    private static SSLConnectionSocketFactory getSSLConnectionSocketFactory() {
        try {
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    //信任所有证书
                    return true;
                }
            }).build();

            return new SSLConnectionSocketFactory(sslContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String postXML(String url, String content) throws Exception {
        return postContent(url, content, "application/xml", null);
    }

    public static String postXML(String url, String content, List<Header> headers) throws Exception {
        return postContent(url, content, "application/xml", headers);
    }


    public static String postJSON(String url, String content) throws Exception {
        return postContent(url, content, "application/json", null);
    }

    public static String postJSON(String url, String content, List<Header> headers) throws Exception {
        return postContent(url, content, "application/json", headers);
    }

    /**
     * 通过request body，postContent 字符串内容，比如这些字符串是JSON/XML格式
     *
     * @param url
     * @param content 参数，name=value
     * @param headers
     * @return
     * @throws Exception
     */
    public static String postContent(String url, String content, String contentType, List<Header> headers) throws Exception {

        HttpPost post = new HttpPost(url);
        post.setConfig(requestConfig);

        post.setHeader(HTTP.CONTENT_ENCODING, CHARSET);

        if (!CollectionUtils.isEmpty(headers)) {
            for (Header header : headers) {
                post.addHeader(header);
            }
        }

        //content非空时，自己加上Content-Length请求头上及其对应值
        StringEntity stringEntity = new StringEntity(content);

        //只需要对StringEntity设置contentType,就会在自己加上Content-Type请求头
        stringEntity.setContentType(contentType);


        post.setEntity(stringEntity);

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(post);

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                return EntityUtils.toString(entity, CHARSET);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("HttpClient.POST请求数据出错", e);
        } finally {
            if (response != null) {
                EntityUtils.consume(response.getEntity()); //会自动释放连接
            }
        }
        return null;
    }


    /**
     * 普通form提交
     *
     * @param url
     * @param nameValuePairList 参数，name=value
     * @param headers
     * @return
     * @throws Exception
     */
    public static String postContent(String url, List<NameValuePair> nameValuePairList, List<Header> headers) throws Exception {

        HttpPost post = new HttpPost(url);
        post.setConfig(requestConfig);

        post.setHeader(HTTP.CONTENT_ENCODING, CHARSET);


        if (!CollectionUtils.isEmpty(headers)) {
            for (Header header : headers) {
                post.addHeader(header);
            }
        }

        if (CollectionUtils.isNotEmpty(nameValuePairList)) {
            HttpEntity he = new UrlEncodedFormEntity(nameValuePairList, CHARSET);
            post.setEntity(he);
        }

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(post);

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                return EntityUtils.toString(entity, CHARSET);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("HttpClient.POST请求数据出错", e);
        } finally {
            if (response != null) {
                EntityUtils.consume(response.getEntity()); //会自动释放连接
            }
        }
        return null;
    }

    public static String postContent(String url, Map<String, String> params, List<Header> headers) throws Exception {
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        return postContent(url, formParams, headers);
    }

    public static String postContent(String url, Map<String, String> params) throws Exception {
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        if (params != null) {

            for (Map.Entry<String, String> entry : params.entrySet()) {
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        return postContent(url, formParams, null);
    }


    public static String get(String url, Map<String, String> params, Header[] headers) throws Exception {

        StringBuffer uriStr = new StringBuffer(url);

        if (params != null) {
            List<NameValuePair> ps = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                ps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            uriStr.append("?");
            uriStr.append(URLEncodedUtils.format(ps, CHARSET));
        }

        HttpGet get = new HttpGet(uriStr.toString());
        get.setConfig(requestConfig);

        if (headers != null) {
            for (Header header : headers) {
                get.addHeader(header);
            }
        }

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get, HttpClientContext.create());

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity, CHARSET);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("HttpClient.GET请求数据出错", e);
        } finally {
            if (response != null) {
                EntityUtils.consume(response.getEntity()); //会自动释放连接
            }
        }
        return null;
    }

    public static String get(String url, Map<String, String> params) throws Exception {
        return get(url, params, null);
    }

    public static String get(String url) throws Exception {
        return get(url, null, null);
    }


    public static void main(String[] args) throws Exception {
        String ret = HttpClientUtils.postJSON("http://localhost:8081/security-rpc/app/user/getUser", "{\"code\": 0}");
        System.out.println("ret:" + ret);
    }
}
