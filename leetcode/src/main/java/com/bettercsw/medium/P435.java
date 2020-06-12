package com.bettercsw.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 不重叠的区间个数
 *
 * Input: [ [1,2], [1,2], [1,2] ]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 *
 * @author csw
 * @date 2020/4/15 22:02
 */
public class P435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int end = intervals[0][1];
        for(int i = 1;i< intervals.length; i++) {
            if(intervals[i][0] < end) {
                continue;
            }
            count++;
            end = intervals[i][1];
        }
        return intervals.length - count;
    }
}
