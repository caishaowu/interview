package com.bettercsw.easy;

import java.util.*;

/**
 * @author csw
 * @date 2020/7/29 16:15
 */
public class P1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
