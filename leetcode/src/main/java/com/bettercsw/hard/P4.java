package com.bettercsw.hard;

import com.alibaba.druid.support.json.JSONUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 寻找两个正序数组的中位数
 * @author csw
 * @date 2020/11/30 17:43
 */
public class P4 {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("to","2");

        System.out.println(JSONUtils.toJSONString(map));

    }
    public  double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int sum = len1 + len2;
        int midIndex = sum / 2;
        if(sum % 2 == 1) {
            return getKthElement(nums1,nums2,midIndex + 1);
        }else {
            int midIndex2 = sum / 2 - 1;
            return (getKthElement(nums1,nums2, midIndex + 1) + getKthElement(nums1,nums2,midIndex2+1)) / 2;
        }

    }
    public  double getKthElement(int[] nums1,int[] nums2,int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while(true) {
            if(index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if(index2 == len2) {
                return nums1[index1 + k - 1];
            }
            if(k == 1) {
                return Math.min(nums1[index1],nums2[index2]);
            }
            int mid = k / 2;
            int newIndex1 = Math.min(index1 + mid,len1) - 1;
            int newIndex2 = Math.min(index2 + mid,len2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            if(pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
