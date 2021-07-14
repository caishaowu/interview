package com.bettercsw.easy;


import java.util.Arrays;

/**
 * @author csw
 * @date 2020/7/20 11:02
 */
public class P69 {
    public static void main(String[] args) {
        int i = 2;
        int j = 3;
        double sum = i+j;
        System.out.println( (sum) /2);
    }


    /**
     * 二分查找数的平方根
     * input：4 output：2
     * input：8 output：2
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 1;
        int high = x;
        while (true) {
            // 取中间值，low + (high - low) / 2 等于 (high + low) / 2
            // 避免 high + low 大于 int 类型的表示范围，导致溢出
            int mid = low + (high - low) / 2;
            //如果 mid * mid > x，说明目标值在 mid 的左边
            if (mid > x / mid) {
                high = mid - 1;
            } else {
                if (mid + 1 > x / mid + 1) {
                    return mid;
                }
                low = mid + 1;
            }
        }
    }

}
