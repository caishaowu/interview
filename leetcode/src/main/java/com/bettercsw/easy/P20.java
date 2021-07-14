package com.bettercsw.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author csw
 * @date 2020/8/11 17:54
 */
public class P20 {

    public static void main(String[] args) {
        P20 p = new P20();
        System.out.println(p.isValid("]["));
    }

    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(map.get(s.charAt(i)));
            } else {
                if (stack.size() <= 0) {
                    return false;
                }
                if (stack.pop() != s.charAt(i)) {
                    return false;
                }

            }
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }
}
