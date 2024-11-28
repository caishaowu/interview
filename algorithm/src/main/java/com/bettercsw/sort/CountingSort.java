package com.bettercsw.sort;

/**
 * @author csw
 * @date 2020/7/17 10:14
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 2, 4, 4};
        sort(a);
        for (int v : a) {
            System.out.print(v);
        }
    }

    private static void sort(int[] a) {
        int max = a[0];
        int length = a.length;
        for (int value : a) {
            if (value > max) {
                max = value;
            }
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < length; i++) {
            count[a[i]]++;
        }

        //依次累加
        for (int i = 1; i <= max; i++) {
            count[i] = count[i - 1] + count[i];
        }

        int[] temp = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            temp[count[a[i]] - 1] = a[i];
            count[a[i]]--;
        }

        System.arraycopy(temp, 0, a, 0, length);

    }


}
