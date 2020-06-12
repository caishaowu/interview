package com.chinaunicom.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author csw
 * @date
 */
public class StreamTest7 {
    public static void main(String[] args) {
        //输出下列字符串中不重复的字符串
        List<String> list = Arrays.asList("hello welcome", "world hello", "heelo world hello", "hello welcome");
        Stream<String[]> stream = list.stream().map(item -> item.split(" "));
        List<String> result = stream.flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
