package com.bettercsw;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author csw
 * @date 2021/1/18 12:02
 */
public class TestMain {

    public static void main(String[] args) {

        System.out.println(test(3, 27));
    }

    public static String test(int n,int k) {

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = n;i > 0; i--) {
            int temp = k - i;
            if(temp < 26) {
                stringBuilder.append((char)('a' + temp));
                k = k - temp - 1;
            }else {
                stringBuilder.append('z');
                k = k - 26;
            }
        }
        return stringBuilder.reverse().toString();

    }


    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    public static List<String> getEndDaysOfMonth(LocalDate date, int n) {
        if (date == null) {
            date = LocalDate.now();
        }
        List<String> result = new ArrayList<>();
        Month month = date.getMonth();
        int length = month.length(date.isLeapYear());
        for (int i = 0; i < n; i++) {
            result.add(LocalDate.of(date.getYear(), month, length - i).toString());

        }

        return result;


    }

    public static boolean isFirstDayOfMonth() {

        LocalDate today = LocalDate.of(2021, 5, 2);
        LocalDate firstDay = LocalDate.of(today.getYear(), today.getMonth(), 1);
        System.out.println(today + ":" + firstDay);
        return firstDay.equals(today);
    }

    public static List<String> getMonths(int intervals) {
        List<String> result = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (int i = 1; i <= intervals; i++) {
            result.add(today.minusMonths(i).toString().substring(0, 7));
        }
        return result;
    }




}
