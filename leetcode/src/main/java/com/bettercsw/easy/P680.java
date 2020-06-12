package com.bettercsw.easy;

/**
 * 回文字符串，最多删除一个字符即可成为回文字符串
 *
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 *
 * @author csw
 * @date 2020/4/15 22:05
 */
public class P680 {

    public boolean validPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j;i++,j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s,i,j-1) || isPalindrome(s,i+1,j);
            }
        }
        return true;

    }
    public boolean isPalindrome(String s,int i,int j) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}
