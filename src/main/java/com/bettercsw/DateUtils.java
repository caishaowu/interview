package com.bettercsw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {

    private static final Logger log = LoggerFactory.getLogger(DateUtils.class);

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYY_MM_DD_HHMM = "yyyy-MM-dd HH:mm";

    public static final String YYYY_MM = "yyyy-MM";

    public static final String YYYY_MM_IN_CHINESE = "YYYY年MM月";

    public static final String YYYY_MM_DD_IN_CHINESE = "yyyy年MM月dd日";

    public static final String YYYY_MM_DD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYY_MM_DD_HHMMSS_S = "yyyy-MM-dd HH:mm:ss.S";

    public static final String YYYY_MM_DD_HHMMSS_SSS = "yyyy-MM-dd HH:mm:ss SSS";

    public static final String YYYYMMDD_HHMMSS = "yyyy/MM/dd HH:mm:ss";

    public static final String YYYYMMDD_SLASH = "yyyy/MM/dd";

    public static final String YYYY_DOC_MM_DOC_DD = "yyyy.MM.dd";

    public static final String YYYYMMDD_HH_MM_SS = "yyyyMMdd HH:mm:ss";

    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss SSS";

    public static final String YYMMDDHHMMSSSSS = "yyMMddHHmmssSSS";

    public static final String YYYY_MM_DD_00 = "yyyy-MM-dd 00:00:00";
    public static final String YYYY_MM_DD_24 = "yyyy-MM-dd 23:59:59";
    public static final String YYMMDD = "yyMMdd";
    /**
     * 存储SimpleDateFormat对应格式发的String类型
     */
    private static Map<String, SimpleDateFormat> map = new HashMap<String, SimpleDateFormat>();

    /**
     * 间隔天数
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 相差天数
     */
    public static int betweenDays(Date beginDate, Date endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);

        try {
            beginDate = sdf.parse(sdf.format(beginDate));
            endDate = sdf.parse(sdf.format(endDate));
        } catch (ParseException e) {
            log.error("", e);
            return 0;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(beginDate);
        long minTime = cal.getTimeInMillis();
        cal.setTime(endDate);
        long maxTime = cal.getTimeInMillis();
        long betweenDays = (maxTime - minTime) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(betweenDays));
    }

    /**
     * 日期加N天
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDayas(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        Date newDate = cal.getTime();
        return newDate;
    }

    /**
     * 日期加N月
     *
     * @param date
     * @param months
     * @return
     */
    public static Date addMonth(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        Date newDate = cal.getTime();
        return newDate;
    }

    /**
     * 日期加N分钟
     *
     * @param date
     * @param minutes
     * @return
     */
    public static Date addMinutes(Date date, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minutes);
        Date newDate = cal.getTime();
        return newDate;
    }

    /**
     * 获取n分钟后的时间
     *
     * @param n 可以是负数
     *          ，负数的话表示n小时前
     * @return
     * @author liangyi
     */
    public static Timestamp getMinutes(int n) {
        Calendar calender = Calendar.getInstance();
        calender.add(Calendar.MINUTE, n);
        Timestamp nMinutesLater = new Timestamp(calender.getTimeInMillis());

        return nMinutesLater;
    }

    /**
     * 获取n秒后的时间
     *
     * @param n
     * @return
     */
    public static Timestamp getSecond(int n) {
        Calendar calender = Calendar.getInstance();
        calender.add(Calendar.SECOND, n);
        Timestamp nMinutesLater = new Timestamp(calender.getTimeInMillis());

        return nMinutesLater;
    }


    /**
     * 将指定格式的日期字符串转成Timestamp
     *
     * @param time
     * @param pattern
     * @return
     * @author mayt
     */
    public static Timestamp getTimestamp(String time, String pattern)
            throws Exception {
        DateFormat format = new SimpleDateFormat(pattern);
        format.setLenient(false);
        Timestamp ts = new Timestamp(format.parse(time).getTime());
        ;
        return ts;
    }

    /**
     * 将指定格式的日期字符串转成Date
     *
     * @param dateStr
     * @param pattern
     * @return
     * @throws Exception
     * @author liangyi
     */
    public static Date getDate(String dateStr, String pattern)
            throws Exception {
        DateFormat format = new SimpleDateFormat(pattern);
        format.setLenient(false);
        Date date = new Date(format.parse(dateStr).getTime());
        return date;
    }

    /**
     * 将string类型yyyyMMddHHmmss时间类型转换为Date类型yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr
     * @return
     * @throws Exception
     * @author liangyi
     */
    public static Date transferDate(String dateStr) throws Exception {
        String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";
        dateStr = dateStr.replaceAll(reg, "$1-$2-$3 $4:$5:$6");
        return DateUtils.getDate(dateStr, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取系统当前时间
     *
     * @return
     * @author liangyi
     */
    public static Timestamp getSysDate() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        return time;
    }

    /**
     * 根据指定的格式输入时间字符串
     *
     * @param pattern
     * @return
     * @author liangyi
     */
    public static String getDateString(String pattern) {
        Timestamp time = getSysDate();
        DateFormat dfmt = new SimpleDateFormat(pattern);
        Date date = time;
        return dfmt.format(date);
    }

    /**
     * 根据指定的格式输入时间字符串
     *
     * @param time
     * @param pattern
     * @return
     */
    public static String getDateString(Timestamp time, String pattern) {
        DateFormat dfmt = new SimpleDateFormat(pattern);
        Date date = time;
        return dfmt.format(date);
    }

    /**
     * 根据指定的格式输入时间字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String getDateString(Date date, String pattern) {
        DateFormat dfmt = new SimpleDateFormat(pattern);
        return dfmt.format(date);
    }

    /**
     * 获取n天后的时间
     *
     * @param n 可以是负数，负数的话表示n天前
     * @return
     * @author liangyi
     */
    public static Timestamp getDays(Date date, int n) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.DATE, n);
        Timestamp nMinutesLater = new Timestamp(calender.getTimeInMillis());

        return nMinutesLater;
    }

    /**
     * 获取日期date的n天后的时间
     *
     * @param n 可以是负数，负数的话表示n天前
     * @return
     * @author liangyi
     */
    public static Timestamp getDays(int n) {
        Calendar calender = Calendar.getInstance();
        calender.add(Calendar.DATE, n);
        Timestamp nMinutesLater = new Timestamp(calender.getTimeInMillis());

        return nMinutesLater;
    }


    /**
     * 获取n 月后的日期
     *
     * @param n
     * @return
     */
    public static Timestamp getMonths(int n) {
        Calendar calender = Calendar.getInstance();
        calender.add(Calendar.MONTH, n);
        Timestamp nMinutesLater = new Timestamp(calender.getTimeInMillis());

        return nMinutesLater;
    }

    public String getDate(int month) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, month);//对月份进行计算,减去12个月
        Date date = cal.getTime();
        return DateUtils.format(date, "yyyy-MM-dd");
    }

    /**
     * 获取从startDate 到 endDate之间的日期列表
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     * @author liangyi
     */
    public static List<String> getDates(Timestamp startDate, Timestamp endDate, String pattern)
            throws ParseException {
        List<String> dates = new LinkedList<String>();

        Calendar start = Calendar.getInstance();

        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        if (pattern == null) {
            pattern = YYYYMMDD;
        }
        DateFormat dfmt = new SimpleDateFormat(pattern);
        while (!start.after(end)) {
            dates.add(dfmt.format(start.getTime()));
            start.add(Calendar.DAY_OF_YEAR, 1);
        }

        return dates;

    }

    /**
     * 转为时间hhmmss格式
     *
     * @param seconds  秒数
     * @param separate 分隔符，在hh、mm、ss之间的分隔符，如:或空等
     * @return
     * @author liangyi
     */
    public static String convertSecondToHhMmSs(int seconds, String separate) {

        int rest = seconds;

        int hour = 0;//小时数
        int min = 0;//分钟数
        int sec = 0;//秒数

        hour = rest / 3600;
        rest = rest % 3600;

        min = rest / 60;
        rest = rest % 60;

        sec = rest;

        String result = (hour < 10 ? "0" + hour : hour) + separate + (min < 10 ? "0" + min : min) + separate +
                (sec < 10 ? "0" + sec : sec);

        return result;

    }

    /**
     * 获取srcDate以后（以前）的N个月
     *
     * @param srcDate
     * @param n       可以是负数
     * @return
     * @author liangyi
     */
    public static List<Date> getNMonthFrom(Date srcDate, int n) {
        if (srcDate == null) {
            return null;
        }
        List<Date> list = new ArrayList<>(Math.abs(n) + 1);

        if (n == 0) {
            list.add(srcDate);
        } else if (n > 0) {
            //后N个月
            list.add(srcDate);

            Calendar calender = Calendar.getInstance();
            for (int i = 1; i <= n; i++) {
                calender.setTime(srcDate);
                calender.add(Calendar.MONTH, i);
                Date oneMonthLater = new Date(calender.getTimeInMillis());
                list.add(oneMonthLater);
            }
        } else {
            //前N个月
            Calendar calender = Calendar.getInstance();
            for (int i = n; i < 0; i++) {
                calender.setTime(srcDate);
                calender.add(Calendar.MONTH, i);
                Date oneMonthEarlier = new Date(calender.getTimeInMillis());
                list.add(oneMonthEarlier);
            }

            list.add(srcDate);
        }

        return list;
    }

//    /**
//     * 获取系统时间
//     *
//     * @param format 14位:yyyyMMddHHmmss,19位：yyyy-MM-dd HH:mm:ss
//     * @return
//     */
//    public static String getSysdate(String format) {
//        Date now = new Date();
//        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//        return DateUtils.format(now, format);
//    }

    /**
     * 通过时间格式化字符串获取SimpleDateFormat
     *
     * @param parsePatterns 时间格式化
     * @return {@link SimpleDateFormat}
     */
    public static SimpleDateFormat getSimpleDateFormat(final String parsePatterns) {
        SimpleDateFormat dateFormat = null;
        if (map.containsKey(parsePatterns)) {
            dateFormat = map.get(parsePatterns);
        } else {
            dateFormat = new SimpleDateFormat(parsePatterns);
            map.put(parsePatterns, dateFormat);
        }
        return dateFormat;
    }

    /**
     * 格式化时间，返回格式化后的时间字符串
     * <p>
     * <pre>
     * 例子,如有一个Date = 2012-08-09:
     * DateUtils.format(date,"yyyy-MM-dd") = "2012-08-09"
     * DateUtils.format(date,"yyyy年MM月dd日") = "2012年08月09日"
     * DateUtils.format(date,"") = null
     * DateUtils.format(date,null) = null
     * </pre>
     *
     * @param date          时间
     * @param parsePatterns 格式化字符串
     * @return String
     */
    public static String format(final Date date, final String parsePatterns) {
        if (StringUtils.isEmpty(parsePatterns) || date == null) {
            return null;
        }
        return getSimpleDateFormat(parsePatterns).format(date);
    }

    /**
     * 简单转换日期类型到默认字符串格式 "yyyy-MM-dd HH:mm:ss"
     *
     * @param date 日期
     * @return String 格式化好的日期字符串 "yyyy-MM-dd HH:mm:ss"
     */
    public static String format(final Date date) {
        return format(date, YYYY_MM_DD_HHMMSS);
    }

    /**
     * 根据周期获取两个时间段内的天数
     *
     * @param date
     * @param py
     * @param cycle
     * @return
     */
    public static int getDaysByRule(Date date, int py, int cycle) {

        Date newDate = new Date();
        //周
        if (cycle == 2) {

            newDate = addDayas(date, 7 * py);
        }

        //月
        else if (cycle == 3) {

            newDate = addMonth(date, py);
        } else {
            return py;
        }

        return betweenDays(date, newDate);
    }


    /**
     * 判断某个时间time1是否在另一个时间time2之前
     *
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 时间time1是否在另一个时间time2之前
     */
    public static boolean beforeTime(final Date time1, final Date time2) {
        final Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(time1);

        final Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(time2);

        return calendar1.before(calendar2);
    }

    /**
     * 返回下个月最后一秒的时间
     *
     * @return
     * @throws Exception
     */
    public static Date getNextMonthLastTime(int end) throws Exception {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, end + 1);
        calendar.set(Calendar.DATE, 0);

        Date date1 = calendar.getTime();

        String yyyymmdd = format(date1, YYYY_MM_DD);
        yyyymmdd += " 23:59:59";

        date1 = getDate(yyyymmdd, YYYY_MM_DD_HHMMSS);

        return date1;

    }


    /**
     * 1 第一季度 2 第二季度 3 第三季度 4 第四季度
     *
     * @param date
     * @return
     */
    public static int getSeason(Date date) {

        int season = 0;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 3;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 4;
                break;
            default:
                break;
        }
        return season;
    }

    public static int getDayOfMonth() {
        Calendar now = Calendar.getInstance();
        int day = now.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    public static int getMonth() {
        Calendar now = Calendar.getInstance();
        int month = now.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * 获取上一个月月份
     *
     * @return
     */
    public static String getBeforeMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        String time = format.format(calendar.getTime());
        return time;
    }


    /**
     * 获取前一天月份第一秒
     *
     * @return
     * @throws Exception
     */
    public static Date getFirstSecondOfYesterDayMonth()
            throws Exception {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, -1);
        now.set(Calendar.DAY_OF_MONTH, now.getActualMinimum(Calendar.DAY_OF_MONTH));
        //设置每天的最大小时
        now.set(Calendar.HOUR_OF_DAY, now.getActualMinimum(Calendar.HOUR_OF_DAY));
        //设置每小时最大分钟
        now.set(Calendar.MINUTE, now.getActualMinimum(Calendar.MINUTE));
        //设置每分钟最大秒
        now.set(Calendar.SECOND, now.getActualMinimum(Calendar.SECOND));
        return now.getTime();
    }

    /**
     * 获得当月月底最后一秒钟的时间（格式：yyyy-MM-dd HH:mm:ss）
     *
     * @return
     * @throws Exception
     */
    public static Date getLastSecondOfCurrentMonth()
            throws Exception {
        Calendar now = Calendar.getInstance();
        now.set(Calendar.DAY_OF_MONTH, now.getActualMaximum(Calendar.DAY_OF_MONTH));
        //设置每天的最大小时
        now.set(Calendar.HOUR_OF_DAY, now.getActualMaximum(Calendar.HOUR_OF_DAY));
        //设置每小时最大分钟
        now.set(Calendar.MINUTE, now.getActualMaximum(Calendar.MINUTE));
        //设置每分钟最大秒
        now.set(Calendar.SECOND, now.getActualMaximum(Calendar.SECOND));
        return now.getTime();
    }

    /**
     * 获取前n天日期、后n天日期00:00：00
     *
     * @param distanceDay 前几天 如获取前7天日期则传-7即可；如果后7天则传7
     * @return
     */
    public static String getOldDate(int distanceDay, String formate) {
        SimpleDateFormat dft = new SimpleDateFormat(formate);
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + distanceDay);
        Date endDate = null;
        try {
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        return DateUtils.format(endDate);
    }

    /**
     * 和系统当前时间间隔分钟数
     *
     * @return 和系统当前时间相差分钟数
     */
    public static long betweenMins(Date inputDate) {
        long diffTime = 0L;
        try {
            diffTime = (System.currentTimeMillis() - inputDate.getTime()) / (1000 * 60);
        } catch (Exception e) {
            log.error("", e);
            return 0;
        }
        return diffTime;
    }

    public static void main(String[] args) {

        Date date2 = addDayas(new Date(), -1);
        System.out.println(date2);
        Date date1 = new Date();
        System.out.println(beforeTime(date1, date2));

        System.out.println(getOldDate(-2, YYYY_MM_DD_00));
        System.out.println(getOldDate(0, YYYY_MM_DD_24));

    }
}
