package com.bettercsw.easy;

/**给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。

 * @author csw
 * @date 2023/1/16 20:15
 */
public class P136 {

    public static void main(String[] args) {
        P136 p136 = new P136();
        int[] nums = {4,1,2,1,2};
        p136.singleNumber(nums);
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;  //异或满足交换律, 两个数相同异或结果为0，不同为1
        }
        return res;

    }
}
