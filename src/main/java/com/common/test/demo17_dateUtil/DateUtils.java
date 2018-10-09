package com.common.test.demo17_dateUtil;

import com.common.test.demo23_util.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public final class DateUtils {
    /**
     * yyyy-MM
     */
    public static String YYYY_MM = "yyyy-MM";
    public static String YYYY_MM_ = "yyyy年MM月";
    public static String YYYY_MM_1 = "yyyy-MM-1 00:00:00.000";
    public static String MM_ = "MM月";
    /**
     * yyyyMMdd
     */
    public static String YYYYMMDD = "yyyyMMdd";
    /**
     * yyyy-MM-dd
     */
    public static String YYYY_MM_DD = "yyyy-MM-dd";
    public static String YYYY_MM_DD_00 = "yyyy-MM-dd 00:00:00.000";
    public static String YYYY_MM_DD_59 = "yyyy-MM-dd 23:59:59";
    public static String YYYY_MM_DD_ = "yyyy年MM月dd日";
    public static String DD_ = "dd日";
    public static String MM_DD_ = "MM月dd日";
    /**
     * yyyy-MM-dd HH
     */
    public static String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
    public static String YYYY_MM_DD_HH_00 = "yyyy-MM-dd HH:00:00.000";
    public static String YYYY_MM_DD_HH_59 = "yyyy-MM-dd HH:59:59.999";
    public static String YYYY_MM_DD_HH_ = "yyyy年MM月dd日 HH";
    public static String YYYY_MM_DD_HH__ = "yyyy年MM月dd日 HH:00:00";
    public static String MM_DD_HH_ = "MM月dd日 HH";
    public static String DD_HH_ = "dd日 HH";
    public static String HH_ = "HH";
    /**
     * yyyyMMdd HH:mm:ss
     */
    public static String YYYYMMDD_HH_MM_SS = "yyyyMMdd HH:mm:ss";
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    /**
     * yyyy-MM-dd HH:mm:ss:sss
     */
    public static String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss:SSS";
    public static String YYYY_MM_DD_HH_MM_SS_SSS_ = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * yyyyMMddHHmmss
     */
    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    /**
     * 时区：中国标准时间 东八区
     */
    private static String TIMEZONE = "GMT+8";

    /**
     * 设置时区
     */
    static {
        initTime();
        StringUtils.format("设置时区:[{0}]", TIMEZONE);
//        System.out.println(StringUtils.format("设置时区:[{0}]", TIMEZONE));
    }

    /**
     * string日期转换string类型
     *
     * @param date
     * @param format
     * @return
     */
    public static String stringToString(String date, String format) {
        return dateToString(stringToDate(date, YYYY_MM_DD_HH_MM_SS), format);
    }

    /**
     * date日期转换date类型
     *
     * @param date
     * @param format
     * @return
     */
    public static Date dateToDate(Date date, String format) {
        return stringToDate(dateToString(date, format), format);
    }

    /**
     * Date日期转换String类型
     *
     * @param date   目标日期
     * @param format 转换日期格式
     * @return
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * String日期转换Date类型
     *
     * @param date   目标日期String
     * @param format 转换日期格式
     * @return
     */
    public static Date stringToDate(String date, String format) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 增加秒
     * <p>
     * 可为负数，则为减法
     *
     * @param date 目标日期
     * @param sec  秒
     * @return
     */
    public static Date addSec(Date date, int sec) {
        return new DateTime(date).plusSeconds(sec).toDate();
    }

    /**
     * 增加分钟
     * <p>
     * 可为负数，则为减法
     *
     * @param date 目标日期
     * @param mins 分钟
     * @return
     */
    public static Date addMin(Date date, int mins) {
        return new DateTime(date).plusMinutes(mins).toDate();
    }

    /**
     * 增加小时
     * <p>
     * 可为负数，则为减法
     *
     * @param date  目标日期
     * @param hours 小时
     * @return
     */
    public static Date addHours(Date date, int hours) {
        return new DateTime(date).plusHours(hours).toDate();
    }

    /**
     * 增加天数
     * <p>
     * 可为负数，则为减法
     *
     * @param date 目标日期
     * @param days 天数
     * @return
     */
    public static Date addDay(Date date, int days) {
        return new DateTime(date).plusDays(days).toDate();
    }

    /**
     * 增加月数
     * <p>
     * 可为负数，则为减法
     *
     * @param date   目标日期
     * @param months 天数
     * @return
     */
    public static Date addMonth(Date date, int months) {
        return new DateTime(date).plusMonths(months).toDate();
    }

    /**
     * 增加年数
     * <p>
     * 可为负数，则为减法
     *
     * @param date  目标日期
     * @param years 年数
     * @return
     */
    public static Date addYear(Date date, int years) {
        return new DateTime(date).plusYears(years).toDate();
    }


    /**
     * 计算两个日期的日差值
     *
     * @param date1
     * @param date2
     * @return
     * @describle date1、date2类型支持String、java.util.Date、org.joda.time.DateTime类型
     */
    public static int datesBetweenDays(Object date1, Object date2) {
        DateTime dateTime1 = formatObject(date1), dateTime2 = formatObject(date2);
        if (null != dateTime1 && null != dateTime2) {
            return Math.abs(Days.daysBetween(dateTime1, dateTime2).getDays());
        }
        return -1;
    }

    /**
     * 计算两个日期的月差值
     *
     * @param date1
     * @param date2
     * @return
     * @describle date1、date2类型支持String、java.util.Date、org.joda.time.DateTime类型
     */
    public static int datesBetweenMonths(Object date1, Object date2) {
        DateTime dateTime1 = formatObject(date1), dateTime2 = formatObject(date2);
        if (null != dateTime1 && null != dateTime2) {
            return Math.abs(Months.monthsBetween(dateTime1, dateTime2).getMonths());
        }
        return -1;
    }

    /**
     * 计算两个日期的年差值
     *
     * @param date1
     * @param date2
     * @return
     * @describle date1、date2类型支持String、java.util.Date、org.joda.time.DateTime类型
     */
    public static int datesBetweenYears(Object date1, Object date2) {
        DateTime dateTime1 = formatObject(date1), dateTime2 = formatObject(date2);
        if (null != dateTime1 && null != dateTime2) {
            return Math.abs(Years.yearsBetween(dateTime1, dateTime2).getYears());
        }
        return -1;
    }

    /**
     * 计算两个日期相减得毫秒差值
     *
     * @param d_1
     * @param d_2
     * @param formart
     * @return
     */
    public static long datesBetweenDates(String d_1, String d_2, String formart) {
        if (StringUtils.isEmpty(d_1) || StringUtils.isEmpty(d_2)) {
            return -1;
        }
        long d_1_min = stringToDate(d_1, formart).getTime();
        long d_2_min = stringToDate(d_2, formart).getTime();
        return Math.abs(d_1_min - d_2_min);
    }

    /**
     * 获取当前月第一天
     *
     * @param format 日期转换格式
     * @return String
     */
    public static String getMonthStartDate(String format) {
        return dateToString(getMonthStartDate(), format);
    }

    /**
     * 获取当前月第一天
     *
     * @return Date
     */
    public static Date getMonthStartDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取当前周第一天
     *
     * @param format 日期转换格式
     * @return String
     */
    public static String getFirstDayOfWeek(String format) {
        return dateToString(getFirstDayOfWeek(), format);
    }

    /**
     * 获取当前周第一天
     *
     * @return Date
     */
    public static Date getFirstDayOfWeek() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取当前季度第一天
     *
     * @param format 日期转换格式
     * @return String
     */
    public static String getFirstDayOfSeason(String format) {
        return dateToString(getFirstDayOfSeason(), format);
    }

    /**
     * 获取当前季度第一天
     *
     * @return Date
     */
    public static Date getFirstDayOfSeason() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        switch (currentMonth) {
            case 1:
            case 2:
            case 3:
                c.set(Calendar.MONTH, 1);
                break;
            case 4:
            case 5:
            case 6:
                c.set(Calendar.MONTH, 3);
                break;
            case 7:
            case 8:
            case 9:
                c.set(Calendar.MONTH, 4);
                break;
            case 10:
            case 11:
            case 12:
                c.set(Calendar.MONTH, 9);
                break;
        }
        c.set(Calendar.DATE, 1);
        return stringToDate(dateToString(c.getTime(), YYYY_MM_DD) + " 00:00:00", YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 获取本年第一天
     *
     * @param format 日期转换格式
     * @return String
     */
    public static String getFirstDayOfYear(String format) {
        return dateToString(getFirstDayOfYear(), format);
    }

    /**
     * 获取本年第一天
     *
     * @return Date
     */
    public static Date getFirstDayOfYear() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, currentYear);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取当月最后一天日期
     *
     * @param format 日期转换格式
     * @return
     */
    public static String getLastDayOfMonth(String format) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dateToString(c.getTime(), format);
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

    /**
     * 获取type下年月日
     *
     * @param type    DateTimeFieldType.dayOfMonth()日 DateTimeFieldType.monthOfYear()月 DateTimeFieldType.year()年
     * @param date    日期
     * @param formart 日期格式 date为string时 使用
     * @return
     */
    public static int getFieldValueByType(DateTimeFieldType type, Object date, String formart) {
        if (StringUtils.isEmpty(date)) {
            return -1;
        }
        DateTime dateTime = null;
        if (date instanceof String) {
            dateTime = new DateTime(stringToDate((String) date, formart));
        } else if (date instanceof Date) {
            dateTime = new DateTime(date);
        } else if (date instanceof DateTime) {
            dateTime = (DateTime) date;
        }
        if (StringUtils.isEmpty(dateTime)) {
            return -1;
        }
        return dateTime.get(type);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getNow() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 获取月份天数
     * <p>
     * 返回0 参数为空 -1 数据类型不对
     * string类型，必须为yyyy-MM-dd
     *
     * @param object string/date类型
     * @return
     */
    public static int getDaysOfMonth(Object object) {
        if (StringUtils.isEmpty(object)) {
            return 0;
        }
        Date date = null;
        if (object instanceof String) {
            date = stringToDate(String.valueOf(object), DateUtils.YYYY_MM_DD);
        } else if (object instanceof Date) {
            date = (Date) object;
        } else {
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    private static void initTime() {
        TimeZone time = TimeZone.getTimeZone(TIMEZONE);
        TimeZone.setDefault(time);
    }

    private static DateTime formatObject(Object date) {
        DateTime dateTime = null;
        if (date instanceof String) {
            dateTime = new DateTime(stringToDate((String) date, YYYYMMDD_HH_MM_SS));
        } else if (date instanceof Date) {
            dateTime = new DateTime(date);
        } else if (date instanceof DateTime) {
            dateTime = (DateTime) date;
        }
        return dateTime;
    }

    /**
     * 日期转字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String dataFormat(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * Unix时间戳转换成指定格式日期
     *
     * @param timestampString
     * @return
     */
    public static Date timeStamp2Date(String timestampString) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_SSS_);
        try {
            Long timestamp = Long.parseLong(timestampString);
            sdf.format(timestamp);
            return sdf.parse(sdf.format(timestamp));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Unix时间戳转换成包含毫秒的日期
     *
     * @return
     */
    public static Date unixLong2Date(String timestampLongString) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_SSS_);
        Long timestamp = Long.parseLong(timestampLongString);
        try {
            return sdf.parse(new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_SSS_).format(new Date(timestamp)));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param minDate 最小时间  20150101
     * @param maxDate 最大时间 20151001
     * @return 日期集合 格式为 年-月
     * @throws Exception
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) throws Exception {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//格式化为年月

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月");//格式化为年月
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf1.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }

    /**
     * 根据时间类型格式化查询日期
     *
     * @description: <p>
     * <b>note:</b>
     * 若时间类型为自定义类型，且开始时间或者结束时间为空，则默认查询近一个季度(即近4个月)数据
     * </p>
     */
    public static class FormartQueryTime {
        public static QueryTimeVo formartDateType(DateTypeEnum dateTypeEnum, String sd, String startDate, String enDate) {
            QueryTimeVo qtv = null;
            if (StringUtils.isNotEmpty(dateTypeEnum)) {
                qtv = new QueryTimeVo();
                Date now = new Date();
                switch (dateTypeEnum) {
                    case TODAY:
                        qtv.setEndDate(dateToString(now, YYYY_MM_DD_HH_MM_SS_SSS_));
                        qtv.setStartDate(dateToString(addHours(new Date(), -11), YYYY_MM_DD_HH_00));
                        break;
                    case WEEK:
                        qtv.setEndDate(dateToString(now, YYYY_MM_DD_HH_MM_SS_SSS_));
                        qtv.setStartDate(dateToString(addDay(new Date(), -6), YYYY_MM_DD_00));
                        break;
                    case SEASON:
                        qtv.setEndDate(dateToString(now, YYYY_MM_DD_HH_MM_SS_SSS_));
                        qtv.setStartDate(dateToString(addMonth(now, -3), YYYY_MM_1));
                        break;
                    case YEAR:
                        qtv.setEndDate(dateToString(now, YYYY_MM_DD_HH_MM_SS_SSS_));
                        qtv.setStartDate(dateToString(addMonth(addYear(now, -1), 1), YYYY_MM_1));
                        break;
                    case UPTONOW:
                        qtv.setEndDate(dateToString(now, YYYY_MM_DD_HH_MM_SS_SSS_));
                        qtv.setStartDate(StringUtils.isEmpty(sd) ? dateToString(new Date(), YYYY_MM_DD_00) : sd);
                        break;
                    case MONTH:
                        qtv.setEndDate(dateToString(now, YYYY_MM_DD_HH_MM_SS_SSS_));
                        qtv.setStartDate(dateToString(addMonth(now, -1), YYYY_MM_DD_00));
                        break;
                    case SELFTIME:
                        if (StringUtils.isEmpty(startDate) || StringUtils.isEmpty(enDate)) {
                            qtv.setStartDate(dateToString(now, YYYY_MM_DD_HH_MM_SS_SSS_));
                            qtv.setEndDate(dateToString(addMonth(now, -3), YYYY_MM_1));
                        } else {
                            qtv.setStartDate(DateUtils.dateToString(DateUtils.stringToDate(startDate, DateUtils.YYYY_MM_DD), DateUtils.YYYY_MM_DD_HH_MM_SS));
                            qtv.setEndDate(DateUtils.dateToString(addDay(DateUtils.stringToDate(enDate, DateUtils.YYYY_MM_DD), 1), DateUtils.YYYY_MM_DD_HH_MM_SS));
                        }
                        break;
                    case TENDAY:
                        qtv.setEndDate(dateToString(now, YYYY_MM_DD_HH_MM_SS_SSS_));
                        qtv.setStartDate(dateToString(addDay(new Date(), -9), YYYY_MM_DD_00));
                        break;
                }
            }
            return qtv;
        }

        /**
         * 根据时间类型获取X坐标数据
         *
         * @param dateTypeEnum
         * @param qtv
         * @return
         */
        public static Map<String, List<String>> getTime_X(DateTypeEnum dateTypeEnum, QueryTimeVo qtv) {
            Map<String, List<String>> map = new HashMap<>();
            List<String> list = new ArrayList<>();
            List<String> listv = new ArrayList<>();
            if (StringUtils.isNotEmpty(dateTypeEnum)
                    && StringUtils.isNotEmpty(qtv)
                    && StringUtils.isNotEmpty(qtv.getStartDate())
                    && StringUtils.isNotEmpty(qtv.getEndDate())) {
                TimeTypeEnum tte = dateTypeEnum.getTimeTypeEnum();
                String startDate = qtv.getStartDate();
                String enDate = qtv.getEndDate();
                String formart = null;
                Date sd = stringToDate(startDate, YYYY_MM_DD_HH_MM_SS);
                Date ed = stringToDate(enDate, YYYY_MM_DD_HH_MM_SS);
                /**验证起始时间合法性，防止非法数据导致死循环,不合法时间数据直接返回null*/
                if (sd.getTime() > ed.getTime()) {
                    return null;
                }
                int startYear = getFieldValueByType(DateTimeFieldType.year(), sd, null);
                int endYear = getFieldValueByType(DateTimeFieldType.year(), ed, null);
                switch (tte) {
                    case DAY:
                        formart = MM_DD_;
                        while (sd.getTime() <= ed.getTime()) {
                            listv.add(dateToString(sd, YYYY_MM_DD_));
                            list.add(dateToString(sd, formart));
                            sd = dateToDate(addDay(sd, 1), YYYY_MM_DD_);
                        }
                        break;
                    case HOURS:
                        /**验证是否跨日 跨月 跨年*/
                        int startMonth2 = getFieldValueByType(DateTimeFieldType.monthOfYear(), sd, null);
                        int endMonth2 = getFieldValueByType(DateTimeFieldType.monthOfYear(), ed, null);
                        int startDay = getFieldValueByType(DateTimeFieldType.dayOfMonth(), sd, null);
                        int endDay = getFieldValueByType(DateTimeFieldType.dayOfMonth(), ed, null);
                        if (startYear == endYear) {
                            if (startMonth2 == endMonth2) {
                                if (startDay == endDay) {
                                    formart = HH_;
                                } else {
                                    formart = DD_HH_;
                                }
                            } else {
                                formart = MM_DD_HH_;
                            }
                        } else {
                            formart = YYYY_MM_DD_HH_;
                        }

                        while (sd.getTime() <= ed.getTime()) {
                            listv.add(dateToString(sd, YYYY_MM_DD_HH_));
                            list.add(dateToString(sd, formart));
                            sd = dateToDate(addHours(sd, 1), YYYY_MM_DD_HH_);
                        }
                        break;
                    case MOUTN:
                        /**验证是否跨年*/
                        if (startYear == endYear) {
                            formart = MM_;
                        } else {
                            formart = YYYY_MM_;
                        }
                        while (sd.getTime() <= ed.getTime()) {
                            listv.add(dateToString(sd, YYYY_MM_));
                            list.add(dateToString(sd, formart));
                            sd = dateToDate(addMonth(sd, 1), YYYY_MM_);
                        }
                        break;
                }
            }
            map.put("xlist", list);
            map.put("listv", listv);
            return map;
        }
    }

    public static class QueryTimeVo {
        private String startDate;
        private String endDate;

        public QueryTimeVo() {
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        @Override
        public String toString() {
            return "QueryTimeVo{" +
                    "startDate='" + startDate + '\'' +
                    ", endDate='" + endDate + '\'' +
                    '}';
        }
    }

//    public static void main(String[] args) {
//    	System.out.println(timeStamp2Date("1529632644478"));

//    	SimpleDateFormat sdf =  new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_SSS_);  
//    	String date = new java.text.SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_SSS_).format(new java.util.Date(1529632644478L));    
//    	System.out.println(unixLong2Date("1529632644478"));
//        System.out.println(addMin(new Date(),5));
//        QueryTimeVo qtv = new QueryTimeVo();
//        qtv.setEndDate("2017-7-21 23:00:00");
//        qtv.setStartDate("2017-7-2 23:00:00");
//        DateTime dateTime = new DateTime(new Date());
//        System.out.println(dateTime.get(DateTimeFieldType.dayOfYear()));
//        System.out.println(dateTime.get(DateTimeFieldType.dayOfMonth()));
//        System.out.println(dateTime.get(DateTimeFieldType.monthOfYear()));
//        System.out.println(dateTime.get(DateTimeFieldType.year()));
//        System.out.println(dateTime.get(DateTimeFieldType.dayOfWeek()));
//        System.out.println(FormartQueryTime.getTime_X(DateTypeEnum.MONTH, qtv));
//		System.out.println(dateToString(addYear(new Date(),-1),YYYY_MM_DD_HH));
//		System.out.println(DateUtils.FormartQueryTime.formartDateType(DateTypeEnum.MONTH,null,null));
//		System.out.println(dateToString(new DateTime(new Date()).plusHours(-1).toDate(),YYYY_MM_DD_HH));
//		System.out.println(dateToString(addMonth(new Date(),-3),YYYY_MM_DD_HH_MM_SS_SSS));
//		System.out.println(getDaysOfMonth(new Date()));
//		System.out.println(getDaysOfMonth("2017-6-12"));
//		System.out.println(dateToString(new Date(),YYYY_MM_DD_HH_MM_SS_SSS));
//		System.out.println(getFirstDayOfYear());
//		System.out.println(getFirstDayOfYear(YYYYMMDDHHMMSS));
//		System.out.println(getFirstDayOfSeason());
//		System.out.println(getFirstDayOfSeason(YYYYMMDDHHMMSS));
//		System.out.println(stringToDate("2013-12-23 00:00:00",YYYY_MM_DD_HH_MM_SS));
//		System.out.println(getNow(YYYYMMDDHHMMSS));
//		System.out.println(getMonthStartDate(YYYYMMDDHHMMSS));
//		System.out.println(getFirstDayOfWeek());
    // DateTime dateTime = new DateTime(new Date());
    // DateTime date = dateTime;
    // date = date.plusDays(67);
    //
    // System.out.println(datesBetweenDays(date,dateTime));
    // System.out.println(datesBetweenMonths(date,dateTime));
    // System.out.println(datesBetweenYears(date,dateTime));
//    }
}
