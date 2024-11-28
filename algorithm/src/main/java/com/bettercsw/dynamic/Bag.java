package com.bettercsw.dynamic;

/**
 * @author csw
 * @date 2020/8/4 14:58
 */
public class Bag {
    public static void main(String[] args) {
        int[] items = new int[]{30, 60, 20, 30, 10, 10};
        System.out.println(bag2(items, 6, 100));

    }

    private static int bag(int[] items, int bagWeight) {
        int length = items.length;
        boolean[][] states = new boolean[length][bagWeight + 1];
        states[0][0] = true;
        if (items[0] <= bagWeight) {
            states[0][items[0]] = true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < bagWeight; j++) {
                if (states[i - 1][j]) {
                    states[i][j] = true;
                }
            }
            for (int j = 0; j <= bagWeight - items[i]; j++) {
                if (states[i - 1][j]) {
                    states[i][j + items[i]] = true;
                }
            }
        }

        for (int i = bagWeight; i >= 0; i--) {
            if (states[length - 1][i]) {
                return i;
            }
        }
        return 0;
    }


    public static int bag2(int[] items, int length, int bagWeight) {
        boolean[] states = new boolean[bagWeight + 1]; // 默认值false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (items[0] <= bagWeight) {
            states[items[0]] = true;
        }
        for (int i = 1; i < length; ++i) { // 动态规划
            for (int j = bagWeight - items[i]; j >= 0; --j) {//把第i个物品放入背包
                if (states[j]) states[j + items[i]] = true;
            }
        }
        for (int i = bagWeight; i >= 0; --i) { // 输出结果
            if (states[i]) return i;
        }
        return 0;
    }

}
