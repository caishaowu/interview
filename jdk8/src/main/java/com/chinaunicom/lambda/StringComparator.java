package com.chinaunicom.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author csw
 * @date
 */
public class StringComparator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("dog","panda","cat");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        Collections.sort(list,(o1,o2)-> o2.compareTo(o1));
        Collections.sort(list,Comparator.reverseOrder());
        System.out.println(list);
    }

}
