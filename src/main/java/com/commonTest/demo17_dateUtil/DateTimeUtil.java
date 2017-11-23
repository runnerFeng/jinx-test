package com.commonTest.demo17_dateUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateTimeUtil {
    public static final String STR_DATETIME_PATTERN = "yyyyMMddHHmmss";
    public static final String STR_DATETIME_PATTERN_LONG = "yyyy-MM-dd HH:mm:ss";
    public static final String STR_DATETIME_PATTERN_SHORT = "yyyyMMddHHmm";
    public static final String STR_DATE_PATTERN = "yyyyMMdd";
    public static final String STR_DATE_PATTERN2 = "yyyy.MM.dd";
    public static final String STR_DATE_PATTERN_LONG = "yyyy-MM-dd";
    public static final String STR_TIME_PATTERN = "HHmmss";
    public static final String STR_TIME_PATTERN_LONG = "HH:mm:ss";
    public static final String STR_TIME_PATTERN_SHORT = "HH:mm";
    public static final String STR_DATETIME_PATTERN_MONTH = "MMddHHmmss";
    public static final String STR_YYYYMM_PATTERN = "yyyyMM";
    public static final String STR_DATE_HOUR_PATTERN = "yyyyMMddHH";
    public static final String STR_SEQDATETIME_PATTERN = "yyMMdd";
    public static final String STR_PART_CHINESE_PATTERN = "yyyy年MM月dd日";
    private static Logger log = LoggerFactory.getLogger(DateTimeUtil.class);

    /**
     * 将日期时间的字符串转化为毫秒数
     *
     * @param strDateTime ,日期时间字符串,格式为pattern的格式
     * @param pattern     日期时间字符串的格式,可为空,默认为"yyyyMMddHHmmss"
     * @return 毫秒数
     */
    public static long dateTimeStrToMilsec(String strDateTime, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat((pattern == null) ? STR_DATETIME_PATTERN : pattern);
        try {
            return sdf.parse(strDateTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将日期时间的字符串转化为秒数
     *
     * @param strDateTime ,日期时间字符串,格式为pattern的格式
     * @param pattern     日期时间字符串的格式,可为空,默认为"yyyyMMddHHmmss"
     * @return 秒数
     */
    public static long dateTimeStrToSecond(String strDateTime, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat((pattern == null) ? STR_DATETIME_PATTERN : pattern);
        try {
            return sdf.parse(strDateTime).getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将毫秒数日期时间转化为字符串
     *
     * @param milsecDateTime ,毫秒数日期时间
     * @param pattern        日期时间字符串的格式,可为空,默认为"yyyyMMddHHmmss"
     * @return
     */
    public static String dateTimeMilsecToStr(long milsecDateTime, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(
                (pattern == null) ? STR_DATETIME_PATTERN : pattern);
        Date dateTime = new Date(milsecDateTime);
        return (dateTime == null) ? null : sdf.format(dateTime);
    }

    /**
     * 将日期时间转化为指定Pattern的字符串
     *
     * @param dateTime ,日期时间
     * @param pattern  ，格式,默认“yyyyMMddHHmmss”
     * @return
     */
    public static String dateTimeToStr(Date dateTime, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat((pattern == null) ? STR_DATETIME_PATTERN : pattern);
        return (dateTime == null) ? null : sdf.format(dateTime).trim();
    }

    public static String convertTimeStampToString(Date asDate,
                                                  String asPattern) {
        if (asDate == null)
            return "";
        SimpleDateFormat lFormat = new SimpleDateFormat();
        if ((asPattern != null) && (asPattern.length() > 0))
            lFormat.applyPattern(asPattern);
        return lFormat.format(asDate);
    }

    public static String timeStampToString(long timestmp, String pattern) {
        SimpleDateFormat lFormat = new SimpleDateFormat();
        if ((pattern != null) && (pattern.length() > 0))
            lFormat.applyPattern(pattern);
        return lFormat.format(timestmp);
    }

    /**
     * 将日期时间的字符串转化为timestmp
     *
     * @param strDateTime ,日期时间字符串,格式为yyyy-mm-dd hh:mm:ss的格式
     * @return timestmp
     */
    public static long dateTimeStrToTimestmp(String strDateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        try {
            return sdf.parse(strDateTime).getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将时间字符串从原格式转化为目标格式
     *
     * @param dateTimeStr ,时间字符串
     * @param srcPattern  ，原格式
     * @param destPattern ，目标格式
     * @return
     */
    public static String dateTimeStrChangePattern(String dateTimeStr, String srcPattern, String destPattern) {
        if (dateTimeStr == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(srcPattern);
        Date date;
        try {
            date = sdf.parse(dateTimeStr);
            sdf.applyPattern(destPattern);
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param pattern
     * @return String
     * @throws Exception
     * @Make 得到当前系统时间
     */
    public static String getSysStringTime(String pattern) {
        if (pattern == null || pattern.equals("")) {
            pattern = STR_DATETIME_PATTERN;
        }
        Long l = System.currentTimeMillis();
        return dateTimeMilsecToStr(l, pattern);
    }

    public static long getTimeMillisAt24() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    /**
     * 把短日期20170608转成长日期2017-06-08
     *
     * @param date
     * @return
     */
    public static String formatDateShortToDatLong(String date) {
        return DateTimeUtil.dateTimeMilsecToStr(DateTimeUtil.dateTimeStrToMilsec(date, DateTimeUtil.STR_DATE_PATTERN), DateTimeUtil.STR_DATE_PATTERN_LONG);
    }

    /**
     * 判断开始时间是否大于现在
     *
     * @throws Exception
     */
    public static boolean isBoolean(String time) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(DateTimeUtil.STR_DATETIME_PATTERN);
        boolean flag = sdf.parse(time).before(new Date());
        if (flag) {
            log.info(" 时间早于当前时间......");
        } else {
            log.info(" 时间 不 早于当前时间......");
        }
        return flag;
    }

    /**
     * 返回yyyyMMdd
     *
     * @return
     */
    public static String getLastdate() {
        Date dNow = new Date(); // 当前时间
        Date dBefore = null;
        Calendar calendar = Calendar.getInstance(); // 得到日历
        calendar.setTime(dNow);// 把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -1); // 设置为前一天
        dBefore = calendar.getTime(); // 得到前一天的时间
        return DateTimeUtil.convertTimeStampToString(dBefore, DateTimeUtil.STR_DATE_PATTERN);
    }

    public static Date parseDate(final String dateValue) {
        return parseDate(dateValue, DateTimeUtil.STR_DATETIME_PATTERN_LONG);
    }

    public static Date parseDate(String dateValue, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            Date date = sdf.parse(dateValue);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据单位字段比较两个时间
     *
     * @param date      时间1
     * @param otherDate 时间2
     * @param withUnit  单位字段，从Calendar field取值
     * @return 等于返回0值, 大于返回大于0的值 小于返回小于0的值
     */
    public static int compareTime(Date date, Date otherDate, int withUnit) {
        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(date);
        Calendar otherDateCal = Calendar.getInstance();
        otherDateCal.setTime(otherDate);

        dateCal.clear(Calendar.YEAR);
        dateCal.clear(Calendar.MONTH);
        dateCal.set(Calendar.DATE, 1);
        otherDateCal.clear(Calendar.YEAR);
        otherDateCal.clear(Calendar.MONTH);
        otherDateCal.set(Calendar.DATE, 1);
        switch (withUnit) {
            case Calendar.HOUR:
                dateCal.clear(Calendar.MINUTE);
                otherDateCal.clear(Calendar.MINUTE);
            case Calendar.MINUTE:
                dateCal.clear(Calendar.SECOND);
                otherDateCal.clear(Calendar.SECOND);
            case Calendar.SECOND:
                dateCal.clear(Calendar.MILLISECOND);
                otherDateCal.clear(Calendar.MILLISECOND);
            case Calendar.MILLISECOND:
                break;
            default:
                throw new IllegalArgumentException("withUnit 单位字段 " + withUnit + " 不合法！！");
        }
        return dateCal.compareTo(otherDateCal);
    }

}