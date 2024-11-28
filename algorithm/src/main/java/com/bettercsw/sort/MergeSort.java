package com.bettercsw.sort;

/**
 * @author csw
 * @date 2020/7/16 10:31
 */
public class MergeSort {
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
        mergeSortInternally(a, 0, a.length - 1);
    }

    private static void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        //防止(p + r) 超过int类型最大值
        int q = p + (r - p) / 2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);
        mergeBySentry(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] temp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        //判断哪个子数组中有剩余数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        //将剩余的数据拷贝到临时数组temp
        while (start <= end) {
            temp[k++] = a[start++];
        }

        for (i = 0; i <= r - p; i++) {
            a[p + i] = temp[i];
        }
    }

    //利用哨兵
    private static void mergeBySentry(int[] a, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = a[p + i];
        }
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = a[q + 1 + i];
        }

        rightArr[r - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {

            if (leftArr[i] <= rightArr[j]) {
                a[k++] = leftArr[i++];
            } else {
                a[k++] = rightArr[j++];
            }
        }
    }
}
