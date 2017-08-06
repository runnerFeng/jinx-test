package com.commonTest.http;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientFactory {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static CloseableHttpClient getDefaultInstance() {
        return httpClient;
    }

}
