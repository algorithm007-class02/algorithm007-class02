package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/4/5 17:52
 * @Description:
 */
public class LeeCode_55_0226 {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i --) {
            if(nums[i] + i >= lastPos)  {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
