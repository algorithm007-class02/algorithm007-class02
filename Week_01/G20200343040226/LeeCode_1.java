package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/3/14 23:44
 * @Description:
 */
public class LeeCode_1 {
    public int[] twoSum(int[] nums, int target) {
        int a[] = new int[2];
        for(int i = 0; i < nums.length - 1 ; i ++) {
            for(int j = i + 1; j < nums.length; j ++) {
                if(nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    break;
                }
            }
        }
        return a;
    }
}
