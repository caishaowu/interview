package com.bettercsw.easy;

/**
 * @author csw
 * @date 2020/8/21 15:56
 */
public class P53 {
    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int num = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            num = Math.max(num, num + nums[i + 1]);
            max = Math.max(num, max);
        }

        return max;
    }
}
