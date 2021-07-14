package com.bettercsw.search;

/**
 * @author csw
 * @date 2020/7/28 14:49
 */
public class KMP {

    public static void main(String[] args) {
        char[] s = new char[]{'b', 'b', 'c', ' ', 'a', 'b', 'c', 'd', 'a', 'b', ' ', 'a', 'b', 'c', 'd', 'a', 'b', 'c', 'd', 'a', 'b', 'd', 'e'};
        char[] p = new char[]{'a', 'b', 'c', 'd', 'a', 'b'};
        System.out.println(kmp(s, p));
    }

    /**
     * 对应下标
     *
     * @param s 主串
     * @param p 模式串
     * @return
     */
    private static int kmp(char[] s, char[] p) {
        int n = s.length;
        int m = p.length;
        int[] next = getNext(p);
        int j = 0;
        int i = 0;
        while (i < n && j < m) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == m) {
            return i - j;
        }
        return -1;
    }

    /**
     * 寻找模式串中最大长度的相同前缀和后缀
     * ‘abab' = 2 'aba' = 1 'a' = 0
     * 对于P的前j+1个序列字符：
     * 若p[k] == p[j]，则next[j + 1 ] = next [j] + 1 = k + 1；
     * 若p[k] ！= p[j]，我们只能去寻找长度更短一点的相同前后缀
     *
     * @param p 模式串
     * @return
     */
    private static int[] getNext(char[] p) {
        int len = p.length;
        int[] next = new int[len];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < len - 1) {

            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || p[k] == p[j]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
