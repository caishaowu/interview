package com.bettercsw.sort;

/**
 * @author csw
 * @date 2020/7/16 9:57
 */
public class SelectSort {
    public static void main(String[] args) {
        Integer[] a = {1, 5, 6, 9, 7, 3, 4, 5};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }


    private static <T extends Comparable<? super T>> void sort(T[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        for (int i = 0; i < a.length - 1; i++) {
            T min = a[i];
            int index = 0;
            for (int j = i + 1; j < a.length; j++) {

                if (a[j].compareTo(min) < 0) {
                    min = a[j];
                    index = j;
                }
            }
            T temp = a[i];
            a[i] = min;
            a[index] = temp;
        }
    }
}
