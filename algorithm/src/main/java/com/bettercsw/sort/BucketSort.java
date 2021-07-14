package com.bettercsw.sort;

import java.math.BigDecimal;

/**
 * @author csw
 * <p>
 * 核心思想：将要排序的数据分到几个有序的桶里，每个桶里的数据再单独进行排序。桶内排完序之后，
 * 再把每个桶里的数据按照顺序依次取出，组成的序列就是有序的了。
 * @date 2020/7/17 10:07
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] a = {1, 5, 6, 9, 7, 3, 4, 5};

        for (int i : a) {
            System.out.print(i);
        }
        System.out.println();
        BigDecimal thisSales = new BigDecimal(1000);
        BigDecimal lastSales = new BigDecimal(0);
        System.out.println(computePercentage(thisSales, lastSales));

    }

    private static String computePercentage(BigDecimal thisSales, BigDecimal lastSales) {
        if (thisSales != null && lastSales != null) {
            if (lastSales.compareTo(BigDecimal.ZERO) != 0) {
                return thisSales.subtract(lastSales).divide(lastSales, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%";
            } else {
                return "100.00%";
            }
        }

        return "0.00%";
    }

    /**
     * @param a
     * @param bucketSize 桶容量
     */
    private static void sort(int[] a, int bucketSize) {
        if (a.length < 2) {
            return;
        }

    }

    private static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        int index = partition(a, start, end);
        quickSort(a, start, index - 1);
        quickSort(a, index + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
        int i = start - 1;
        int j = end;
        int pivot = a[end];
        while (true) {
            while (a[++i] < pivot && i < end) ;
            while (a[--j] > pivot && j > start) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, end, i);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
