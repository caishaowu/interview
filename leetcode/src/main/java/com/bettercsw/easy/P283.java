package com.bettercsw.easy;

/**
 * @author csw
 * @date 2020/9/3 17:31
 */
public class P283 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int pos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[pos++] = num;
            }
        }

        while (pos < nums.length) {
            nums[pos++] = 0;
        }

    }
}
