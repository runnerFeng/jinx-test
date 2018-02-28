package com.common.test.demo17_dateUtil;

import com.github.fartherp.framework.common.util.DateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.util.Calendar.*;

/**
 * @author jinx
 * @date 2018/2/28 15:19
 * Desc:
 */
public class DateUtil2 {
    public Map<String, String> getTime(Integer datype, String startTime, String endTime) {
        Map<String, String> params = new HashMap<>();
        Date start = null;
        Date end = new Date();
        if (DatypeEnum.TODAY.getCode().equals(datype)) {
            // 今天
            Calendar c = Calendar.getInstance();
            c.set(HOUR_OF_DAY, 0);
            c.set(MINUTE, 0);
            c.set(SECOND, 0);
            startTime = DateUtil.format(DateUtil.yyyy_MM_dd_HH_mm_ss, c.getTime());
            endTime = DateUtil.format(DateUtil.yyyy_MM_dd_HH_mm_ss, end);
        } else if (DatypeEnum.WEEK.getCode().equals(datype)) {
            // 近1周
            start = DateUtil.getDateByCalendar(new Date(), Calendar.WEEK_OF_YEAR, -1);
            startTime = DateUtil.format(DateUtil.yyyy_MM_dd_HH_mm_ss, start);
            endTime = DateUtil.format(DateUtil.yyyy_MM_dd_HH_mm_ss, end);
        } else if (DatypeEnum.MONTH3.getCode().equals(datype)) {
            // 近1季
            start = DateUtil.getDateByCalendar(new Date(), Calendar.MONTH, -3);
            startTime = DateUtil.format(DateUtil.yyyy_MM_dd_HH_mm_ss, start);
            endTime = DateUtil.format(DateUtil.yyyy_MM_dd_HH_mm_ss, end);
        } else if (DatypeEnum.YEAR.getCode().equals(datype)) {
            // 近1年
            start = DateUtil.getDateByCalendar(new Date(), Calendar.YEAR, -1);
            startTime = DateUtil.format(DateUtil.yyyy_MM_dd_HH_mm_ss, start);
            endTime = DateUtil.format(DateUtil.yyyy_MM_dd_HH_mm_ss, end);
        } else if (DatypeEnum.NOW.getCode().equals(datype)) {
            // 至今
            endTime = DateUtil.format(DateUtil.yyyy_MM_dd_HH_mm_ss, end);
        } else if (DatypeEnum.MONTH.getCode().equals(datype)) {
            // 近1月
            start = DateUtil.getDateByCalendar(new Date(), Calendar.MONTH, -1);
            startTime = DateUtil.format(DateUtil.yyyy_MM_dd_HH_mm_ss, start);
            endTime = DateUtil.format(DateUtil.yyyy_MM_dd_HH_mm_ss, end);
        } else {
            // 自定义时间
            // do nothing
        }
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        return params;
    }
}
