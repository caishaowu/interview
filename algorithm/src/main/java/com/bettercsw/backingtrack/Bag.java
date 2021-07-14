package com.bettercsw.backingtrack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 0-1 背包问题:背包总的承载重量是 Wkg。现在我们有 n 个物品，每个物品的重量不等，并且不可分割。
 * 我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 *
 * @author csw
 * @date 2020/7/28 17:29
 */
public class Bag {
    public static int MAX_WEIGHT = Integer.MIN_VALUE; //记录背包中物品的最大总重量
    private static boolean[][] men = new boolean[10][100];  //备忘录，避免冗余计算

    public static void main(String[] args) {
        int[] items = new int[]{90, 60, 20, 30, 10, 10};
        Set set = new HashSet();
        new String(String.valueOf(set));
        f(0, 0, 100, items);
        System.out.println(MAX_WEIGHT);

    }


    private static void f(int count, int currWeight, int bagWeight, int[] items) {
        if (count == items.length || currWeight == bagWeight) {
            if (currWeight > MAX_WEIGHT) {
                MAX_WEIGHT = currWeight;
            }
            return;
        }
        if (men[count][currWeight]) return;
        men[count][currWeight] = true;
        f(count + 1, currWeight, bagWeight, items);
        currWeight = currWeight + items[count];
        if (currWeight <= bagWeight) {
            f(count + 1, currWeight, bagWeight, items);
        }
    }

}
