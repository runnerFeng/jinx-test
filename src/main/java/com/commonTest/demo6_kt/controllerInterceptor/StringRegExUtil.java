package com.commonTest.demo6_kt.controllerInterceptor;

import org.springframework.util.StringUtils;

public class StringRegExUtil {

    private static final String MOBILE_REGEX = "^1[3|4|5|7|8][0-9]{9}";
    private static final String PASSWORD_REGEX = "^[0-9]{6}";
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static boolean isValidMobileNumber(String mobileNumber) {
        if (StringUtils.isEmpty(mobileNumber)) {
            return false;
        } else {
            return mobileNumber.matches(MOBILE_REGEX);
        }
    }

    public static boolean isValidePassword(String password) {
        if (StringUtils.isEmpty(password)) {
            return false;
        } else {
            return password.matches(PASSWORD_REGEX);
        }
    }

    /**
     * 校验邮箱
     *
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return email.matches(REGEX_EMAIL);
    }

    /**
     * unicode 转字符串
     */
    public static String unicode2Str(String unicode) {

        StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {

            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);

            // 追加成string
            string.append((char) data);
        }

        return string.toString();
    }

    /**
     * 字符串转换unicode
     */
    public static String str2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }
}
