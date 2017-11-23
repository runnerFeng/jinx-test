package com.common.test.demo6_kt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mei Xianzhi 2014-12-25 0:08:45
 */
public final class DateUtils {

    /**
     * 获取充值账户过期时间
     *
     * @return
     */
    public static Date getRechargeAccountExpireTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2099, 12, 31, 23, 59, 59);
        return calendar.getTime();
    }

    public static long getTimeInMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    public static String format(Date date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat _fmt = new SimpleDateFormat(format);
        return _fmt.format(date);
    }

    /**
     * 获取指定个月之后的事件
     *
     * @author Mei Xianzhi
     * @date 2012-8-20 下午05:02:03
     */
    public static Date getAfterSomeMonth(Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }

    public static Date getEndTimeOfDay(Date date) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.set(Calendar.HOUR_OF_DAY, 23);
        cl.set(Calendar.MINUTE, 59);
        cl.set(Calendar.SECOND, 59);
        cl.set(Calendar.MILLISECOND, 997);
        return cl.getTime();
    }

    public static Date getBeginTimeOfDay(Date date) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.set(Calendar.HOUR_OF_DAY, 00);
        cl.set(Calendar.MINUTE, 00);
        cl.set(Calendar.SECOND, 00);
        cl.set(Calendar.MILLISECOND, 0);
        return cl.getTime();
    }

    public static Date parase(String dateStr) {
        String style = "yyyy-MM-dd HH:mm:ss";
        return parase(dateStr, style);
    }

    /**
     * 字符串转换成相应格式的日期
     *
     * @param dateStr 日期字符串
     * @param style   日期格式
     * @return 转换后的日期
     * @author Mei Xianzhi
     */
    public static Date parase(String dateStr, String style) {

        if (null == dateStr || "".equals(dateStr.trim())) {
            throw new IllegalArgumentException("the dateStr must not be empty");
        }

        if (null == style || "".equals(style.trim())) {
            throw new IllegalArgumentException("the style must not be empty");
        }

        Date date = null;

        SimpleDateFormat format = new SimpleDateFormat(style);
        try {
            date = format.parse(dateStr);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }

    /**
     * @param date
     * @param amount
     * @return the date after modify
     * @author Mei Xianzhi
     */
    public static Date addYears(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    /**
     * @param date
     * @param amount
     * @return the date after modify
     * @author MeiXianzhi
     */
    public static Date addMonths(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    /**
     * @param date
     * @param amount
     * @return the date after modify
     * @author MeiXianzhi
     */
    public static Date addWeeks(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    /**
     * @param date
     * @param amount
     * @return the date after modify
     * @author MeiXianzhi
     */
    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DATE, amount);
    }

    /**
     * @param date
     * @param amount
     * @return the date after modify
     * @author MeiXianzhi
     */
    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    /**
     * @param date
     * @param amount
     * @return the date after modify
     * @author MeiXianzhi
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    /**
     * 指定时间加上给定的毫秒数
     *
     * @param date   指定的时间
     * @param amount
     * @return the date after modify
     * @author Mei Xianzhi
     */
    public static Date addSeconds(Date date, int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    /**
     * add some millisecond for date
     *
     * @param date
     * @param amount
     * @return the date after modify
     * @author Mei Xianzhi
     */
    public static Date addMilliseconds(Date date, int amount) {
        return add(date, Calendar.MILLISECOND, amount);
    }

    /**
     * @param date
     * @param calendarField
     * @param amount
     * @return the date after modify
     * @author Mei Xianzhi
     */
    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(calendarField, amount);
            return c.getTime();
        }
    }

}
