package com.bettercsw.easy;

import java.util.HashMap;
import java.util.Map;

/**给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
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

    /**
     * 这里使用了摩尔投票法来解决这个问题,摩尔投票法的思想是:假设当前元素为众数，并初始化计数器为1，遍历数组，
     * 如果下一个元素与当前元素相同，则计数器+1，否则-1，如果计数器为0，则更新当前元素为下一个元素，重置计数器为1。
     * 因为多数元素的数量大于总数的一半，所以最后剩下的元素一定是多数元素。
     * @param nums
     * @return
     */
    public int majorityElementB(int[] nums) {
        int cnt = 0;
        int majority = 0;
        for(int num : nums) {
            if (cnt == 0) {
                majority = num;
            }
            cnt += majority == num ? 1 : -1;
        }
        return majority;
    }
}
