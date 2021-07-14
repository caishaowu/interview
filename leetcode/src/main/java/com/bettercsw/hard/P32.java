package com.bettercsw.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author csw
 * @date 2020/8/12 10:53
 */
public class P32 {

    public static void main(String[] args) {
        P32 p = new P32();
        System.out.println(p.longestValidParentheses("(()()(()()()"));
    }

    public int longestValidParentheses(String s) {
        int n = s.length();
        int longest = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    if (s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
        }

        if (stack.isEmpty()) {
            longest = n;
        } else {
            int a = n;
            int b = 0;
            while (!stack.isEmpty()) {
                b = stack.pop();

                longest = Math.max(longest, a - b - 1);
                a = b;
            }
            longest = Math.max(longest, a);
        }

        return longest;
    }
}
