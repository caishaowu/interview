package com.bettercsw.search;

/**
 * @author csw
 * @date 2020/7/24 15:06
 */
public class BF {

    public static void main(String[] args) {
        String str = "helloWorld";
        String pattern = "lloWor";
        System.out.println(bf(str, pattern));

    }

    private static boolean bf(String str, String pattern) {

        int n = str.length();
        int m = pattern.length();

        for (int i = 0; i < n - m + 1; i++) {
            StringBuilder subStr = new StringBuilder();
            for (int j = i; j < m + i; j++) {
                subStr.append(str.charAt(j));
            }
            if (subStr.toString().equals(pattern)) {
                return true;
            }
        }

        return false;
    }
}
