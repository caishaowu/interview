package com.bettercsw.sort;

/**
 * @author csw
 * @date 2020/6/3 10:31
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {0, 4, 2, 9, 1, 7, 8, 4};
        sort(a);
        for (int i : a) {
            System.out.print(i);
        }
    }


    private static void sort(int[] a) {

        if (a == null || a.length <= 1) {
            return;
        }
        quickSort(a, 0, a.length - 1);

    }

    private static void quickSort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition1(a, p, r);
        quickSort(a, p, q - 1);
        quickSort(a, q + 1, r);
    }

    private static int partition1(int[] a, int p, int r) {
        int i = p;
        int pivot = a[r];

        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    swap(a, i, j);
                    i++;
                }
            }
        }
        swap(a, i, r);
        return i;

    }

    private static int partition2(int[] nums, int start, int end) {
        int i = start;
        int j = end + 1;
        while (true) {
            while (nums[++i] < nums[start] && i < end) ;
            while (nums[--j] > nums[start] && j > start) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }

        swap(nums, start, j);
        return j;
    }

    private static int partition3(int[] a, int low, int hight) {
        int i, j, pivot;
        i = low;
        j = hight;
        pivot = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= pivot)
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < pivot)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = pivot;// 将基准数值替换回 a[i]
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
