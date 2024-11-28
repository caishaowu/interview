package com.bettercsw.hard;

import java.util.*;

/**
 * @author csw
 * @date 2020/8/11 17:30
 */
public class P239 {


    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length < k || k <= 0) {
            return null;
        }

        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>(k);

        for (int i = 0; i < nums.length; i++) {
            //队头出队
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);

            if (i >= k - 1) {
                result[index++] = nums[deque.peek()];
            }
        }

        return result;


    }

    public int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums.length < k || k <= 0) {
            return null;
        }

        int[] result = new int[nums.length - k + 1];
        int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            if (queue.size() == k) {
                queue.remove(nums[i - k]);
            }
            queue.add(nums[i]);

            if (i >= k - 1) {
                result[index++] = queue.peek();
            }
        }

        return result;


    }


}
