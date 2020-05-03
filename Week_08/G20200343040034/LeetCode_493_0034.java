package com.alang.learn.week8;

import java.util.HashMap;

/**
 *给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_493_0034 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(new int[]{1,3,2,3,1}));
        System.out.println(solution.reversePairs(new int[]{2,4,3,5,1}));
    }

    static public class Solution {
        public int reversePairs(int[] nums) {
            return mergeSort(nums,0,nums.length-1);
        }
        private int mergeSort(int[] nums,int start,int end){
            if(start >= end)return 0;
            int mid = (start+end)>>1;
            int count = mergeSort(nums,start,mid)+mergeSort(nums,mid+1,end);
            int j = mid+1;
            for(int i = start;i<=mid;i++){
                while(j<=end && ((nums[i] >> 1) + (nums[i] & 1)) > nums[j]) j++;
                count += j-(mid+1);
            }
            merge(nums,start,mid,end);
            return count;
        }

        private void merge(int[] nums,int start,int mid,int end){
            int[] temp = new int[end-start+1];
            int i = start,j=mid+1,index = 0;
            while(i <= mid && j<=end){
                temp[index++]= nums[i] <= nums[j]?nums[i++]:nums[j++];
            }
            while(i<=mid)temp[index++] = nums[i++];
            while(j<=end) temp[index++] = nums[j++];
            System.arraycopy(temp, 0, nums, start, temp.length);
        }
    }
}
