package com.bettercsw.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author csw
 * @date 2020/7/16 9:33
 */
public class InsertSort {

    public static void main(String[] args) {
        Integer[] a = {1, 5, 6, 9, 7, 3, 4, 5};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
        Arrays.sort(a);
    }

    private static <T extends Comparable<? super T>> void sort(T[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            T temp = a[i];
            int j;
            for (j = i; j > 0 && temp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }
}
