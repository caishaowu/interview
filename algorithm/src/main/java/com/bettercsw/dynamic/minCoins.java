package com.bettercsw.dynamic;

/**
 * 如果我们要支付 w 元，求最少需要多少个硬币。比如，我们有 3 种不同的硬币，1 元、3 元、5 元，
 * 我们要支付 9 元，最少需要 3 个硬币（3 个 3 元的硬币）。
 * f(n) = 1 + min(f(n-1),f(n-3),f(n-5))
 *
 * @author csw
 * @date 2020/8/6 10:53
 */
public class minCoins {
    public static void main(String[] args) {
        System.out.println(getMinCoins(50));
    }

    private static int getMinCoins(int money) {
        int[] minCoins = new int[money + 1];
        if (money == 1 || money == 3 || money == 5) {
            return 1;
        }
        minCoins[0] = 0;
        minCoins[1] = 1;
        minCoins[2] = 2;
        minCoins[3] = 1;
        minCoins[4] = 2;
        for (int i = 5; i <= money; i++) {
            minCoins[i] = 1 + Math.min(Math.min(minCoins[i - 1], minCoins[i - 3]), minCoins[i - 5]);
        }
        return minCoins[money];
    }
}
