package com.bettercsw.hard;

import java.util.Arrays;

/**
 * @author csw
 * @date 2020/8/11 14:16
 */
public class P41 {
    public int firstMissingPositive(int[] nums) {

        int minPositive = 1;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                if (nums[i] > 0) {
                    if (nums[i] == minPositive) {
                        minPositive++;

                    } else {
                        return minPositive;
                    }
                }
            }

        }
        return minPositive;
    }
}
