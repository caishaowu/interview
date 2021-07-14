package com.bettercsw.easy;

import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author csw
 * @date 2021/6/16 16:36
 */
public class P26 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length < 1) {
            return 0;
        }
        int cnt = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[cnt] != nums[i]) {
                nums[++cnt] = nums[i];
            }
        }
        return ++cnt;
    }

}
