package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/4/4 16:49
 * @Description:
 */
public class LeeCode_33_0226 {
    public int search(int[] nums, int target) {
        //二分查找，判断条件变更，target分别和【left，mid】,【mid，right】比较
        if(nums == null && nums.length == 0) return -1;
        return bSearch(nums,0,nums.length - 1,target);
    }
    //单调，边界，索引
    private int bSearch(int[] nums,int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if(target == nums[mid]) return mid;
            // 左有序
            if(nums[left] <= nums[mid]) {
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if(target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
