package com.bettercsw.sort;

/**
 * 冒泡排序：
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * <p>
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * <p>
 * 针对所有的元素重复以上的步骤，除了最后一个；
 * <p>
 * 重复步骤1~3，直到排序完成。
 *
 * @author csw
 * @date 2020/7/15 16:17
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {1, 5, 6, 9, 7, 3, 4, 5};
        sort(a);
        for (int i : a) {
            System.out.print(i + " ");
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
