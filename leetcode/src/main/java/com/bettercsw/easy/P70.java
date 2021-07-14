package com.bettercsw.easy;

/**
 * @author csw
 * @date 2020/8/6 10:59
 */
public class P70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }

    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int[] men = new int[n];
        men[0] = 1;
        men[1] = 2;
        for (int i = 2; i < n; i++) {
            men[i] = men[i - 1] + men[i - 2];
        }
        return men[n - 1];

    }
}
