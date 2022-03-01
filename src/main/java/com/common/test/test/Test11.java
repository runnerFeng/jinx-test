package com.common.test.test;

import com.alibaba.fastjson.JSONArray;
import com.common.test.demo23_util.JsonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jinx
 * @Date 2021/11/29
 * @Desc
 */
@Slf4j
public class Test11 {

    public static void main(String[] args) {
        List<AsiabillLocalPaymentMethod> list = new ArrayList<>();
        JSONArray currencyList = new JSONArray();
        currencyList.add("BRL");
        currencyList.add("USD");
        AsiabillLocalPaymentMethod method = new AsiabillLocalPaymentMethod("BR","巴西","Brazil",currencyList,"Brazilian local Credit card","Credit_Card_Brazil","BrazilianCard巴西本地信用卡");
        AsiabillLocalPaymentMethod method1 = new AsiabillLocalPaymentMethod("BR","巴西","Brazil",currencyList,"payment with installments","Credit_Card_Brazil","BrazilianCard巴西本地信用卡");

        list.add(method);
        list.add(method1);

        log.info("json result:{}", JsonUtils.toJsonString(list));
    }
}
