/*
 * Copyright (c) 2017. juzhen.io. All rights reserved.
 */

package com.common.test.demo17_dateUtil;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2017/12/14
 */
public enum DatypeEnum {
    TODAY(0, "今天"),
    WEEK(1, "周"),
    MONTH3(2, "季"),
    YEAR(3, "年"),
    NOW(4, "至今"),
    USER_DEFINED(5, "自定义时间"),
    MONTH(6, "月"),
    ;


    private Integer code;
    private String desc;

    private DatypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

//    public static DatypeEnum getDate(Integer code) {
//        DatypeEnum[] allEnums = values();
//        for (DatypeEnum e : allEnums) {
//            if (e.getCode() == code) {
//                return e;
//            }
//        }
//        return NOW;
//    }
}
