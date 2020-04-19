package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/4/5 00:54
 * @Description:
 */
public class LeeCode_153_0226 {

    public int findMin(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }

        //二分
        int left  = 0;
        int right = nums.length - 1;
        if(nums[right] > nums[0]) {
            return nums[0];
        }

        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if(nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if(nums[mid] > nums[0]) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
