package com.chinaunicom.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author csw
 * @date
 */
public class MyList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        //外部迭代
        for (Integer i : list) {
            System.out.println(i);
        }
        // 内部迭代（Lambda）
        list.forEach(i -> System.out.println(i));

        //方法引用
        list.forEach(System.out::println);
    }
}
