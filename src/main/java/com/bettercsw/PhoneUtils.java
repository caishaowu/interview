package com.bettercsw;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author csw
 * @date 2022/1/19 11:38
 */
public class PhoneUtils {

    public static final String PHONE_REGEX = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(16[5,6])|(17[0-8])|(18[0-9])|(19[1、5、8、9]))\\d{8}$";
    /**
     * 手机号脱敏筛选正则
     */
    public static final String PHONE_BLUR_REGEX = "(\\d{3})\\d{4}(\\d{4})";

    /**
     * 手机号脱敏替换正则
     */
    public static final String PHONE_BLUR_REPLACE_REGEX = "$1****$2";

    public static boolean isPhoneNumber(String phoneNumber) {
        if (StringUtils.isEmpty(phoneNumber)) {
            return false;
        }
        if (phoneNumber.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(PHONE_REGEX);
            Matcher m = p.matcher(phoneNumber);
            return m.matches();
        }
    }

    /**
     * 手机号脱敏处理
     *
     * @param phone
     * @return
     */
    public static final String blurPhone(String phone) {
        boolean checkFlag = isPhoneNumber(phone);
        if (!checkFlag) {
            return phone;
        }
        return phone.replaceAll(PHONE_BLUR_REGEX, PHONE_BLUR_REPLACE_REGEX);
    }

    public static void main(String[] args) {
        System.out.println(blurPhone("18620028932"));
    }
}
