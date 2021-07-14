package com.bettercsw.search;

/**
 * @author csw
 * @date 2020/7/27 16:41
 */
public class TrieTree {

    private TrieNode root = new TrieNode('/');

    //插入一个字符串，字符串由'a-z'组成
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode trieNode = new TrieNode(text[index]);
                p.children[index] = trieNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEndingChar;   //不能完全匹配，只是前缀返回false
    }


    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }


}
