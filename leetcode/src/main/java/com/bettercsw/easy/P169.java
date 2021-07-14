package com.bettercsw.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author csw
 * @date 2020/8/11 11:34
 */
public class P169 {
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) > (nums.length / 2)) {
                return nums[i];
            }
        }
        return 0;

    }
}
