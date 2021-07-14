package com.bettercsw.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author csw
 * @date 2020/7/29 17:42
 */
public class P15 {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int s = i + 1;
            int e = nums.length - 1;
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (s < e) {
                    if (nums[i] + nums[s] + nums[e] < 0) {
                        s++;
                    } else if (nums[i] + nums[s] + nums[e] > 0) {
                        e--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[s], nums[e]));
                        s++;
                        e--;
                        while (s < e && nums[s] == nums[s - 1]) {
                            s++;
                        }
                        while (s < e && nums[e] == nums[e + 1]) {
                            e--;
                        }
                    }
                }
            }
        }
        return result;
    }

}
