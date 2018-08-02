package com.common.test.demo6_kt.rsaEncrypt.v1;

/**
 * @author jinx
 * @date 2018/7/27 18:03
 * Desc:签名类型
 */
public enum SignTypeEnum {
    /**
     * 使用该算法对RSA密钥的长度不限制，推荐使用2048位以上
     */
    SIGN_TYPE_RSA("RSA", "SHA1WithRSA"),
    /**
     * 使用该算法强制要求RSA密钥的长度至少为2048
     */
    SIGN_TYPE_RSA2("RSA2", "SHA256WithRSA"),
    ERROR("ERROR", "ERROR_ALGORITHMS");
    private String key;
    private String value;

    SignTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static SignTypeEnum getType(String key) {
        SignTypeEnum[] allEnums = values();
        for (SignTypeEnum e : allEnums) {
            if (e.getKey() == key) {
                return e;
            }
        }
        return ERROR;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
