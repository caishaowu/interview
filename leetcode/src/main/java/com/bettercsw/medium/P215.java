package com.bettercsw.medium;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * @author csw
 * @date 2020/6/2 17:37
 */
public class P215 {

    /**
     * 解法一：算法复杂度O(NlogN)，空间复杂度 O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];

    }

    /**
     * 解法二：算法复杂度O(NlogK)，空间复杂度 O(K)
     * @param nums
     * @param k
     * @return
     */
    public  int findKthLargest2(int[] nums, int k) {
        //小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int val : nums) {
            queue.add(val);
            if(queue.size() > k) {
                 queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * 解法三：算法复杂度O(N)，空间复杂度 O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {
        int end = nums.length - 1;
        int start = 0;
        k = nums.length - k;
        while(start < end) {
            int num = partition(nums, start, end);
            if(num == k) {
                break;
            }
            if(num < k) {
                start = num + 1;
            }else {
                end = num - 1;
            }


        }
        return nums[k];

    }
    private int partition(int[] nums,int start,int end) {
        int i = start;
        int j = end + 1;
        while(true) {
            while(nums[++i] < nums[start] && i < end );
            while(nums[--j] > nums[start] && j > start);
            if(i >= j) {
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,start,j);
        return j;
    }
    private void swap(int[] nums,int i ,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}



