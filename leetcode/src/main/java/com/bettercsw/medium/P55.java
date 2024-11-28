package com.bettercsw.medium;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * @author csw
 * @date 2020/8/21 16:14
 */
public class P55 {

    public boolean canJump(int[] nums) {
        // 能跳到最远的距离
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            //不断更新最远距离
            k = Math.max(i + nums[i], k);
        }

        return true;
    }


}
