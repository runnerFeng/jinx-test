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
        List<PassionLocalPaymentMethod> list = new ArrayList<>();
        PassionLocalPaymentMethod method = new PassionLocalPaymentMethod("China","中国","Alipay","alipay_cn","alipay_cn");
        PassionLocalPaymentMethod method1 = new PassionLocalPaymentMethod("China","中国","Wechatpay","tenpay_cn","tenpay_cn");
        PassionLocalPaymentMethod method2 = new PassionLocalPaymentMethod("UK","英国","Trustly","trustly","trustly");
        PassionLocalPaymentMethod method3 = new PassionLocalPaymentMethod("Global","全球","Bitcoin","bitcoin","bitcoin");

        PassionLocalPaymentMethod method4 = new PassionLocalPaymentMethod("Finland","芬兰","Trustly","trustly","trustly");
        PassionLocalPaymentMethod method5 = new PassionLocalPaymentMethod("Latvia","拉脱维亚","Trustly","trustly","trustly");
        PassionLocalPaymentMethod method6 = new PassionLocalPaymentMethod("Lithuania","立陶宛","Trustly","trustly","trustly");
        PassionLocalPaymentMethod method7 = new PassionLocalPaymentMethod("Netherlands","荷兰","Trustly","trustly","trustly");

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
