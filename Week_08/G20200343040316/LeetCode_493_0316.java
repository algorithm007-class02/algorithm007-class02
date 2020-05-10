package com.wxs.algorithm1.week08;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/10
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_493_0316 {


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 1};

        LeetCode_493_0316 reversePairs493 = new LeetCode_493_0316();

        int i = reversePairs493.reversePairs(arr);
        System.out.println(i);
    }


    public int reversePairs(int[] nums) {
        return reversePairsHelper(nums, 0, nums.length - 1);
    }

    private int reversePairsHelper(int[] nums, int begin, int end) {

        if (end <= begin) {
            return 0;
        }

        int mid = (end + begin) >> 1;

        int total = reversePairsHelper(nums, begin, mid)+reversePairsHelper(nums, mid + 1, end);

        int count = 0;

        for(int left = begin,right = mid+1; left <= mid;){
            if(right >end || (long)nums[left] <= 2L* nums[right]){
                left++;
                total += count;
            }else {
                right++;
                count++;
            }
        }


        int[] temp = new int[end - begin + 1];

        int i = begin, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            temp[k++] = nums[i] > nums[j] ? nums[j++] : nums[i++];
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= end) temp[k++] = nums[j++];


        for (int l = 0; l < temp.length; l++) {
            nums[begin + l] = temp[l];
        }

        return total;
    }



}
