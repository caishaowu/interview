package com.bettercsw.easy;

import java.util.Arrays;

/**
 * 题目描述：给孩子分配饼干。数组`int[] g`表示孩子的个数及需要的饼干大小，数组`int[] s`表示你拥有的饼干个数及相应大小
 * 找出能满足孩子需要的饼干个数。
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3], [1,1]
 * <p>
 * Output: 1
 * <p>
 * Explanation:你有3个孩子，分别需要size为1、2、3大小的饼干，而你只有两个size为1的饼干，故只能满足一个孩子的需要，输出1
 * <p>
 * Example 2:
 * <p>
 * Input: [1,2], [1,2,3]
 * <p>
 * Output: 2
 *
 * @author csw
 * @date 2020/4/25 10:48
 */
public class P455 {
    public static void main(String[] args) {
        P455 p = new P455();
        int[] s = new int[0];
        int[] g = new int[0];
        System.out.println(p.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                result++;
            } else {
                j++;
            }
        }
        return result;
    }
}
