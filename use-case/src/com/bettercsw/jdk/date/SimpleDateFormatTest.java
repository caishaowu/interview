package com.bettercsw.jdk.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author csw
 * @date 2022/6/2 14:50
 */
public class SimpleDateFormatTest {

    public static void main(String[] args) throws Exception {
        System.out.println(convertWithT("2022-06-02T04:37:45.000Z"));
    }

    /**
     * @param timestamp "2022-05-29T14:57:50.000Z"
     * @return string
     */
    public static String convertWithT(String timestamp) throws ParseException {

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC+8"));
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sdf.parse(timestamp));
    }
}
