package com.common.test.demo53_RSA;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * @Author jinx
 * @Date 2022/2/10
 * @Desc
 */
@Slf4j
public class RSATest {

    private static final String TEST_URL = "https://celer-api.LianLianpay-inc.com/v3/merchants/%s/payments/%s/shipments";
    private static final String MERCHANT_ID = "202201140000927001";
    private static final String TEST_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuTYC2QsJQKOftKa4Payl\n" +
            "ajnWt7FeKdNn4k73L1noIcgLXTRiMCYqh3r/NZXs6kFwduJHNd8JgizE1a0bKUi4\n" +
            "ejzG/8jLcvzhUYwOyWxTL+XglALcAnDBKZ0eGVtecO7DbDZz6oKrB6bdozbn/3mF\n" +
            "gjMiuwMlaCEnh9ggSHpHvseXB7E3GwsgVb7tWsEbWYKu9fsm+2noPM32smF0s2sl\n" +
            "J1Kn81hUfvgewyJ+SDf3yVkdgcJW4LwLDIFKwtyHSPiWmu4Uoa7pGDoKQAEPZUX6\n" +
            "6GYMlG+z71d5piiy0BODfoM1bzl4mtF90djzb5HM3t3L6MwTNlfH2Za3mf8tz5R/\n" +
            "XQIDAQAB\n";
    private static final String TEST_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC5NgLZCwlAo5+0\n" +
            "prg9rKVqOda3sV4p02fiTvcvWeghyAtdNGIwJiqHev81lezqQXB24kc13wmCLMTV\n" +
            "rRspSLh6PMb/yMty/OFRjA7JbFMv5eCUAtwCcMEpnR4ZW15w7sNsNnPqgqsHpt2j\n" +
            "Nuf/eYWCMyK7AyVoISeH2CBIeke+x5cHsTcbCyBVvu1awRtZgq71+yb7aeg8zfay\n" +
            "YXSzayUnUqfzWFR++B7DIn5IN/fJWR2BwlbgvAsMgUrC3IdI+Jaa7hShrukYOgpA\n" +
            "AQ9lRfroZgyUb7PvV3mmKLLQE4N+gzVvOXia0X3R2PNvkcze3cvozBM2V8fZlreZ\n" +
            "/y3PlH9dAgMBAAECggEAKYjUQKo56/YFtbSBsssJ2XWZEl7DWCvhqx28TzEhXpoG\n" +
            "+mLp9hRJC1Lo8rJpi+sa9n4uLAWVk0zI44ZLhgmZ3UfN9MSp42KUgP4gvsj9Ksup\n" +
            "fmfZwO5aUyO6AUO9PSQ+TQE1I40kH7YrFBQXGPK+nwEqs7ez5tMwk0VDkB1kA4NL\n" +
            "SRLf6847/wSFA4MU5gyieXe4c0/VqFBovJGjhRZHVS5XX7JpP9paGni1E6KSb2yJ\n" +
            "KhQ8a+xbheKTpMj85Ei6P9S7dy/QWBkhZ6AM0OJf5MV9JTBpkoEmz4Ii0SZc8HOz\n" +
            "Trnj6ibpz58zBkfCh0dqliYw+Bh0SMK+AVQvf97GwQKBgQDfIHF6Grb1etMd83t0\n" +
            "mN+Ep5RmN9cmF2x8/78RvMq+3K1yP4yhXgOdB7rqaM/KcT2RX5Uqmm0uqm3fzwPN\n" +
            "cxbQPtBHp5+w2pRQQK4X1pr/gUKenntp8W7OszT65fG3+kA1W+mWhARjGtxN2c3Y\n" +
            "1XTuSkjRQ2Ca2494gREyOPjqjQKBgQDUf4TWcBnIsok4hgyHZZlQjjgtYqJdrGP7\n" +
            "loyTuPxlmrBq6k1P1qwL5hnG5yoPu5XVJCe6ykrCfrXNK1S7506dJ8G0LJpm3yk6\n" +
            "RYe8ydFgVzYRnQXiyd38FyYNYd0hLyTIiardyTRllnLsuzgRhpAK0+v5x3bP4vWf\n" +
            "fYA22FucEQKBgQCdZq2mjaHzminEPzcgEZfcZLtzQIEuBegqZd/MC3qbGeHhbqMu\n" +
            "UrwJ0qIxKq8rCKd+HgeEflv3R5MrB0aPcFjvnuAfLEii4g8ubfJiLqo5BF6Stwoo\n" +
            "uoCIoDMHq57RQmB5Q9WMsKTHpPM0mCl2hV5vm0ezF+zWUXzsbWBMJZSzIQKBgQC1\n" +
            "ZMV4Z+kasY0BeyxmyAvAACdkVrZTUD1pHnKSB28tLIc8PRYR+SaUYa/PYrU9CNw2\n" +
            "Pc7MXLLEpHV81mhWnnU1IiLwMsL63bTL0V61gXIB03CMSIYlujyMXRZWhhvFoAC+\n" +
            "TwZUnNTlgzBHdOm/zCZZl93wMpzxiMQziWZRaw+IgQKBgG12CSlnO3KZixB2K6tG\n" +
            "qp18u/dDmc/xQv2N7XBEERnXkUy+SjPv2aivpKhllVyZCYI4HrP8aUgpFklBdWwR\n" +
            "Ln17um69VS2u74VZJvA5/8hynQ/awaaFQp2h0zjrbVuJEtmII4vvl27IQ5ns1kCU\n" +
            "UhMCuo8u7ZKlwfbnUQJ76uhw\n";
    private static final String TEST_LIANLIAN_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQClqT+4Ls3fLbr0MeGuSn0gKsfv/ENf5jfP65fICpW8fvvMeyJrrXklLd1aJ90uMPtwHQUUb7RgP1+0AiRvhx6AeZuuvLuOg2ktuLh/DfMRWWa2T9u/8gg2woiVlqki4+y3Dl3G0ET1x8IGJQGmL/d+d/5dBFVygVuSx7Fx2FTeFXr3dfaOX61y82Ed0/5rJS9q4GxRVcYGMciuSb3bWifrLl0lQ2buw16KSOghclk9aP4MIfauBnA2SwMAP9o1MGES7MWKV7gCH6waU/v2KkyRWbVku2yYuGvjorJawVILQ3VQAxrFaVoC/Qxi2Kg1Q/zQ04wT8DqpBBms3zuUrTZxAgMBAAECggEBAJFxtjr8BM4UNVbeUJkYVyEdzmp6HaEd3BSVcK419N8I0gPmfALzzDADQ5s68qryYF8/a01VAZWbLmg5lUnB5NrBahkRJM5ru7Vjv7/1PFoYFuCr3nB4jBOf2hETtK2oVRUm7Nh31IPBfSyt4vPIm0+TBGUgP/EHd6G356ffWiucYA03knqYwQPn21vOztVlZ9MME3G44bhnmB1u5O39toenKgVvcdYPDIQYDZAY0vID7BgvGB02mrCq6WHlpSK0d/zJr6Ih6prRLtvIsmtkBmgVMWlXqhl80bBAAW+hyXSeduI8Bg8aeRnuuP36zSKlom3mvTz5C9Xxi51GS0/nG90CgYEA2v3byOudd3G+AFVi12TipkekceE4r4OLbhmz9bEMhfivHtM3tNdH4OMWZGGzQ6whbsZTRDWHfyPcQ6gjwI/RgeQL98jq9ZlzIIhvYSUVManKHZm2/Zg/AZzjlZtrAs7q5YCIuFwvnsLCljQqTm0aLiZdaXvgBXFVr082ZFxrTnsCgYEAwags6/O+3xHZUucxnr3PDEdpK616uRA+KULqlMlyW6qwY+ijfscBreUJvn2U0AhIHYVIXe0r+owoqgLmP1i46AN4G9fwh/9Bsz0coc93JclkmTpMnV/uaMyGbnLpujtPRQoOWmgMbwWNvcVFxviZDJiCJI2LU2aPdK4HjT4lcQMCgYEAuUM384M4pPrppXiW9OfZQpirStghT4J2q389GmZc1N3ssKQ5pVjW6y7SG7v3nxF4+zD28mZiqbGZvvb4wAgrUrqtUUN9WqclmWky6Lkpc+lTHrWS9HkfHGswsblYz3hjiiKyB12dv66+Vbnt7IkqM86rCfkNLS2TMotN1ZvGAA8CgYAlLcpiCkusu9qDRguKtFoZu2P/lLCo8utcNJKgugQQgTaYF8O7xS0XW4+BWM7HGa/uqvX3wl7dHSd5bFET/E6TjIb0oYJ2OZU9ehATKKdxQ7bijATFefNlf06XycwBiv1u/b0/shYhAmnx8vuwdW28s1LY/auv+VK1Tev5O+MoTQKBgClULa5c1hIaaPFm5r8H2pj3GKyIZ2is4j6k9Kr+w1a31W5xDzn+ZfVOqxNCRAG64TTZVq0hata7zwhYSSa+f7JtMk5nijedPFEPODr6ejBwfPUljPdhsHidshFtZ+GzwhcjohAF2vmT5UY7Z2S3saGqt69iUEnwSPYz4jx3H9gK";

    public static void main(String[] args) {
        // 构造数据
        Shippment shippment1 = new Shippment();
        shippment1.setCarrier_code("china-ems");
        shippment1.setCountry("DE");
        shippment1.setTracking_no("123456");

        Shippment shippment2 = new Shippment();
        shippment2.setCarrier_code("fedex");
        shippment2.setCountry("CN");
        shippment2.setTracking_no("654321");

        List<Shippment> shippmentList = Lists.newArrayList();
        shippmentList.add(shippment1);
        shippmentList.add(shippment2);

        UploadTrackingNumber number = new UploadTrackingNumber();
        number.setMerchant_id(MERCHANT_ID);
        number.setMerchant_transaction_id("698611134466363392");
        number.setShipments(shippmentList);
        number.setCountry("DE");
        // 排序
        Map<String, Object> traceMap = Maps.newTreeMap();
        traceMap.put("merchant_transaction_id", number.getMerchant_transaction_id());
        traceMap.put("merchant_id", number.getMerchant_id());
        traceMap.put("shipments", number.getShipments());
        traceMap.put("country",number.getCountry());
        log.info("trace:{}", traceMap);

        StringBuilder plainTextStr = new StringBuilder();
        String subSignStr;
        for (String key : traceMap.keySet()) {
            if (key.equals("shipments")) {
                subSignStr = buildShippments(key, (List<Shippment>) traceMap.get(key));
            } else {
                subSignStr = buildPlainText(key, (String) traceMap.get(key));
            }
            plainTextStr.append(subSignStr);
        }
        String plainText = plainTextStr.substring(0, plainTextStr.length() - 1);
        log.info("plainText:{}", plainText);

        // encrypt/decrypt
//        RSA rsa = new RSA(null, TEST_PUBLIC_KEY);
//        String encrypt = rsa.encryptBase64(plainText, KeyType.PublicKey);
//        log.info("encryptStr:{}", encrypt);

//        RSA rsa1 = new RSA(TEST_PRIVATE_KEY, null);
//        String decrypt = rsa1.decryptStr(encrypt, KeyType.PrivateKey);
//        log.info("decryptStr:{}", decrypt);

        // sign/verify
        RSA rsa = new RSA(TEST_LIANLIAN_PRIVATE_KEY, null);
        String signStr = rsa.encryptBase64(plainText, KeyType.PrivateKey);
        log.info("signStr:{}", signStr);
//        RSA rsa1 = new RSA(null, TEST_PUBLIC_KEY);
//        String verifyStr = rsa1.decryptStr(signStr, KeyType.PublicKey);
//        log.info("verifyStr:{}", verifyStr);

        // url
        String remoteUrl = String.format(TEST_URL, number.getMerchant_id(), number.getMerchant_transaction_id());
        log.info("remoteUrl:{}", remoteUrl);
        // header
        Map<String, String> header = Maps.newHashMap();
        String timestamp = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
        String timezoneID = TimeZone.getDefault().getID();
        header.put("sign-type", "RSA");
        header.put("timestamp", timestamp);
        header.put("timezone", timezoneID);
        header.put("Content-Type", "application/json");
        header.put("signature", signStr);
        log.info("header:{}",header);

        String response = HttpRequest.post(remoteUrl)
                .headerMap(header, true)
                .body(JSONUtil.toJsonStr(number))
                .execute().body();

        log.info("response:{}",response);

    }

    private static String buildShippments(String key, List<Shippment> shippments) {
        StringBuilder simpleBuilder = new StringBuilder();
        for (Shippment shippment : shippments) {
            Map<String, String> shippmentMap = Maps.newTreeMap();
            shippmentMap.put("tracking_no", shippment.getTracking_no());
            shippmentMap.put("country", shippment.getCountry());
            shippmentMap.put("carrier_code", shippment.getCarrier_code());
            buildShipment(shippmentMap, simpleBuilder);
        }
        return simpleBuilder.toString();
    }

    private static StringBuilder buildShipment(Map<String, String> shippmentMap, StringBuilder simpleBuilder) {
        for (String key : shippmentMap.keySet()) {
            simpleBuilder.append(key).append("=").append(shippmentMap.get(key)).append("&");
        }
        return simpleBuilder;
    }

    private static String buildPlainText(String key, String value) {
        StringBuilder simpleBuilder = new StringBuilder();
        simpleBuilder.append(key).append("=").append(value).append("&");
        return simpleBuilder.toString();
    }

}
