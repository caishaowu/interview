package com.chinaunicom.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author csw
 * @date 2019/11/11 17:11
 */
public class MyListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, -5, 0, 30);
        //JDK1.7写法
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(list);

        //JDK1.8写法
        list.sort(Comparator.comparingInt(i -> i));
        System.out.println(list);
    }
}
