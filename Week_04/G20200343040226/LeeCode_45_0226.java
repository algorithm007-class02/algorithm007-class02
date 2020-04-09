package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/4/5 17:59
 * @Description:https://leetcode-cn.com/problems/jump-game-ii/
 */
public class LeeCode_45_0226 {
    public int jump(int[] nums) {
        int end = 0;
        int maxPos = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i ++) {
            //找到跳的最远的
            maxPos = Math.max(maxPos, nums[i] + i);
            if(i == end) { //遇到边界，更新边界，步数加1
                end = maxPos;
                steps ++;
            }
        }
        return steps;
    }
}
