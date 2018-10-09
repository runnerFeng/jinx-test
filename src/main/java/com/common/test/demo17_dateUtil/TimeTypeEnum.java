package com.common.test.demo17_dateUtil;


import com.common.test.demo23_util.StringUtils;

public enum TimeTypeEnum {
    HOURS(0, "小时"),
    DAY(1, "天"),
    MOUTN(2, "月");
    private int code;
    private String desc;

    private TimeTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public final static TimeTypeEnum newInstance(int code) {
        TimeTypeEnum[] s_ = TimeTypeEnum.values();
        if (StringUtils.isNotEmpty(s_)) {
            for (TimeTypeEnum s_s : s_) {
                if (s_s.getCode() == code) {
                    return s_s;
                }
            }
        }
        return null;
    }
}
