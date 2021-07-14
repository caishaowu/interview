package com.bettercsw.backingtrack;

/**
 * @author csw
 * @date 2020/7/30 10:19
 */

public class Pattern {
    public static void main(String[] args) {
        char[] ch = new char[]{'a', 'b', '*', 'd'};
        Pattern pattern = new Pattern(ch, 4);
        System.out.println(pattern.match(new char[]{'a', 'b', 'c', 'c', 'd'}, 5));
    }

    private boolean matched = false;
    private char[] pattern; // 正则表达式
    private int plen; // 正则表达式长度

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean match(char[] text, int tlen) { // 文本串及长度
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    /**
     * @param ti   当前字符串下标
     * @param pj   正则表达式下标
     * @param text 匹配字符串
     * @param tlen 字符串长度
     */
    private void rmatch(int ti, int pj, char[] text, int tlen) {
        if (matched) return; // 如果已经匹配了，就不要继续递归了
        if (pj == plen) { // 正则表达式到结尾了
            if (ti == tlen) matched = true; // 文本串也到结尾了
            return;
        }
        if (pattern[pj] == '*') { // *匹配任意个字符
            for (int k = 0; k <= tlen - ti; ++k) {
                rmatch(ti + k, pj + 1, text, tlen);
            }
        } else if (pattern[pj] == '?') { // ?匹配0个或者1个字符
            rmatch(ti, pj + 1, text, tlen);
            rmatch(ti + 1, pj + 1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) { // 纯字符匹配才行
            rmatch(ti + 1, pj + 1, text, tlen);
        }
    }
}
