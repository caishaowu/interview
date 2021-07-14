package com.bettercsw.medium;

/**
 * @author csw
 * @date 2020/7/29 17:41
 */
public class P5 {

    public static void main(String[] args) {
        P5 p = new P5();
        System.out.println(p.longestPalindrome("cbbd"));
    }

    int start = 0;
    int maxLength = 1;

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i - 1, i + 1);
            expandAroundCenter(s, i, i + 1);
        }

        return s.substring(start, start + maxLength);
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

            if (right - left + 1 > maxLength) {
                start = left;
                maxLength = right - left + 1;
            }
            left--;
            right++;
        }

    }

}
