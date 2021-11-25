package com.common.test.test;

import com.common.test.demo23_util.JsonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jinx
 * @Date 2021/11/11
 * @Desc
 */
@Slf4j
public class Test7 {
    public static void main(String[] args) {
        List<LocalPaymentMethod> list = new ArrayList<>();
        LocalPaymentMethod method = new LocalPaymentMethod("China","中国","Alipay","alipay_cn","alipay_cn");
        LocalPaymentMethod method1 = new LocalPaymentMethod("China","中国","Wechatpay","tenpay_cn","tenpay_cn");
        LocalPaymentMethod method2 = new LocalPaymentMethod("UK","英国","Trustly","trustly","trustly");
        LocalPaymentMethod method3 = new LocalPaymentMethod("Global","全球","Bitcoin","bitcoin","bitcoin");

        LocalPaymentMethod method4 = new LocalPaymentMethod("Finland","芬兰","Trustly","trustly","trustly");
        LocalPaymentMethod method5 = new LocalPaymentMethod("Latvia","拉脱维亚","Trustly","trustly","trustly");
        LocalPaymentMethod method6 = new LocalPaymentMethod("Lithuania","立陶宛","Trustly","trustly","trustly");
        LocalPaymentMethod method7 = new LocalPaymentMethod("Netherlands","荷兰","Trustly","trustly","trustly");

        list.add(method);
        list.add(method1);
        list.add(method2);
        list.add(method3);
        list.add(method4);
        list.add(method5);
        list.add(method6);
        list.add(method7);

        log.info("json result:{}", JsonUtils.toJsonString(list));
    }
}
