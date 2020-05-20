package com.wxs.algorithm1.week09;

import java.util.Arrays;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/17
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_300_0316 {

    public int lengthOfLIS(int[] nums) {

        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }

        return res;
    }

}
