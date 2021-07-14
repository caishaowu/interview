package com.bettercsw.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author csw
 * @date 2020/7/29 16:52
 */
public class P3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int i = 0;
        int j = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
                maxLength = Math.max(set.size(), maxLength);
            } else {
                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(j));
                    j++;
                }
                set.add(s.charAt(i));
                i++;
            }

        }
        return maxLength;

    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;

    }


}
