package com.chinaunicom.Stream;

import java.util.stream.IntStream;

/**
 * @author csw
 * @date
 */
public class StreamTest3 {
    public static void main(String[] args) {


        IntStream.of(1,2,3).forEach(System.out::println);
        //[3,8)
        IntStream.range(3,8).forEach(System.out::println);
        //[3,8]
        IntStream.rangeClosed(3,8).forEach(System.out::println);
    }
}
