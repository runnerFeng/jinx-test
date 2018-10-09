package com.common.test.demo17_dateUtil;


import com.common.test.demo23_util.StringUtils;

public enum DateTypeEnum {
    TODAY(0, "表示今天：统计间隔默认为小时，显示近12个小时内的数据趋势"),
    WEEK(1, "表示近1周：统计间隔为天，显示近7天的数据趋势"),
    SEASON(2, "表示近1季：统计间隔为月，显示近4个月的数据趋势"),
    YEAR(3, "表示近1年：统计间隔为月，显示近1年的数据趋势"),
    UPTONOW(4, "表示至今：统计间隔为月，是从有数据开始到现在数据趋势"),
    SELFTIME(5, "表示自定义时间，取间隔一年的时间差值"),
    MONTH(6, "表示近1月：统计间隔为天，显示近1月的数据趋势"),
    TENDAY(7, "表示近1月：统计间隔为天，显示近10的数据趋势");

    private int code;
    private String desc;

    private DateTypeEnum(int code, String desc) {
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

    public final static DateTypeEnum newInstance(int code) {
        DateTypeEnum[] s_ = DateTypeEnum.values();
        if (StringUtils.isNotEmpty(s_)) {
            for (DateTypeEnum s_s : s_) {
                if (s_s.getCode() == code) {
                    return s_s;
                }
            }
        }
        return null;
    }

    public final TimeTypeEnum getTimeTypeEnum() {
        TimeTypeEnum tte = TimeTypeEnum.MOUTN;
        switch (this.getCode()) {
            case 0:
                tte = TimeTypeEnum.HOURS;
                break;
            case 1:
            case 6:
            case 7:
                tte = TimeTypeEnum.DAY;
                break;
        }
        return tte;
    }
}
