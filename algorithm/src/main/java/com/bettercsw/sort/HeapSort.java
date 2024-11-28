package com.bettercsw.sort;


import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * @author csw
 * @date 2020/7/22 15:05
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] a = new int[]{0, 9, 6, 3, 1, 5};
        sort(a, 3);
        for (int i : a) {
            System.out.print(i);
        }
    }

    private static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            k--;
            heapify(a, k, 1);

        }


    }

    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(a, n, i);
        }
    }

    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i * 2] > a[i]) maxPos = i * 2;
            if (i * 2 + 1 <= n && a[i * 2 + 1] > a[maxPos]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }
}
