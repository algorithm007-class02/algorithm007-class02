package com.practice.cyc.java.leetcode;

import java.util.*;

/**
 * @author: lengyue
 * @decription:
 * @time: 2020/3/22
 */
public class TwoWeek {

    public static void main(String[] args) {
        int[] nums = {7,4,5,6};
        System.out.println(trap(nums));
    }

    /**
     * 两数求和-hashmap遍历
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }

    /**
     * 字母异位词
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] cha = s.toCharArray();
            Arrays.sort(cha);
            String ss = String.valueOf(cha);
            if (!map.containsKey(ss)) {
                map.put(ss, new ArrayList<String>());
            }
            map.get(ss).add(s);
        }
        return new ArrayList(map.values());
    }

    /**
     * 接雨水的最大面积
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int length = height.length;
        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;
        int[] left = new int[length];
        int[] right = new int[length];
        for (int i = 0; i < length; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            }
            left[i] = leftMax;
            if(height[length - 1 - i] > rightMax) {
                rightMax = height[length - 1 - i];
            }
            right[length - 1 - i] = rightMax;
        }
        for (int j = 0; j < length; j++) {
            if(height[j] < left[j] && height[j] < right[j]) {
                sum += Math.min(left[j],right[j]) - height[j];
            }
        }
        return sum;
    }

}
