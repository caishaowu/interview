package com.chinaunicom.Stream;

import java.util.stream.IntStream;

/**
 * @author csw
 * @date
 */
public class StreamTest6 {
    public static void main(String[] args) {
        //导致程序一直无法结束
        // IntStream.iterate(0, i->(i +  1) % 2).distinct().limit(6).forEach(System.out::println);

        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);
    }
}
