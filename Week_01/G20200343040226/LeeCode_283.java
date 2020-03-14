package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/3/14 23:48
 * @Description:
 */
public class LeeCode_283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int temp = 0;
        for( int i = 0; i < nums.length; i++ ) {
            if(nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index ++;
            }
        }
    }
}
