package com.bettercsw.sort;

/**
 * @author csw
 * @date 2020/7/15 16:17
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {1, 5, 6, 9, 7, 3, 4, 5};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void sort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
