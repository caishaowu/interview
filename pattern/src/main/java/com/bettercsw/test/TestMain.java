package com.bettercsw.test;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author csw
 * @date 2020/6/18 9:58
 */
public class TestMain {

    public static void main(String[] args) {
        List<Test> list = new ArrayList<>();
        list.add(new Test("51", "33"));
        list.add(new Test("51", "35"));
        list.add(new Test("52", "36"));
        list.add(new Test("53", "37"));
        list.add(new Test("52", "38"));

        Map<String, String> map = list.stream().collect(Collectors.toMap(Test::getProvinceCode, Test::getCityCode, (ex, re) -> ex + "," + re));

        if (StringUtils.isBlank("null")) {
            System.out.println(111);
        }


    }
}
