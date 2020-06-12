package com.chinaunicom.Stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author csw
 * @date
 */
public class StreamTest2 {
    public static void main(String[] args) {
        //对集合的数乘2再累加
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println(list.stream().map(i->i*2).reduce(0,Integer::sum));
    }
}
