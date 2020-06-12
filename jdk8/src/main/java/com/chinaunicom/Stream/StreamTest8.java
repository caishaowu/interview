package com.chinaunicom.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author csw
 * @date
 */
public class StreamTest8 {
    public static void main(String[] args) {
        //
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu");
        list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).
                 collect(Collectors.toList()).forEach(System.out::println);


    }
}
