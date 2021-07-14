package com.bettercsw.easy;

/**
 * @author csw
 * @date 2020/9/3 17:31
 */
public class P242 {

    public boolean isAnagram(String s, String t) {

        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
