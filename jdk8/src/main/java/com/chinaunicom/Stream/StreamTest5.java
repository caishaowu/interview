package com.chinaunicom.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author csw
 * @date
 */
public class StreamTest5 {
    public static void main(String[] args) {
        //找出流中大于2的元素，然后每个元素乘以2，然后忽略掉流中的前两个元素，然后再取流中的两个元素
        //最后求出流中元素的和
        Stream<Integer> stream = Stream.iterate(1, item -> item + 2).limit(6);
        System.out.println(stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum());
        //min() 返回OptionalInt
        stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).min().ifPresent(System.out::println);
        IntSummaryStatistics intSummaryStatistics = stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(intSummaryStatistics.getAverage());

        //不允许对同一个Stream进行两次操作，每次中间操作之后都会生成新的stream，建议使用方法链的调用方式


        //Stream的中间操作是Lazy的，没有遇到终止操作是不会执行 代码的
        List<String> list =Arrays.asList("hello","world","hello world");
        list.stream().map(item ->{
            String result = item.substring(0,1).toUpperCase() + item.substring(1);
            System.out.println("test");
            return result;
        });     //程序没有任何输出
    }
}
