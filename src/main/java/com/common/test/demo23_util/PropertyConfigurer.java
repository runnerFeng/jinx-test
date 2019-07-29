/*
 * Copyright (c) 2017. juzhen.io. All rights reserved.
 */

package com.common.test.demo23_util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

public class PropertyConfigurer extends PropertyPlaceholderConfigurer {

    private static Properties properties;

    public static final String EMAIL_URL = "email.url";

    public static final String SMS_URL = "sms.url";

    public static final String IS_SEND_SMS = "isSendSms";

    public static final String NODE_IP = "node.ip";

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        properties = props;
    }

    public static String getStringValue(String key) {
        return properties.getProperty(key);
    }

    public static String getEmailUrl() {
        return getStringValue(EMAIL_URL);
    }

    public static String getSmsUrl() {
        return getStringValue(SMS_URL);
    }

    public static String getIsSendSms() {
        return getStringValue(IS_SEND_SMS);
    }

    public static String getNodeIp() {
        return getStringValue(NODE_IP);
    }
}
