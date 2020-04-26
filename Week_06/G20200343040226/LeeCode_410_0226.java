package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/4/19 17:10
 * @Description:
 */
public class LeeCode_410_0226 {
    // 1. 子问题 前i个元素分成j组，problem(i,j) = min(MAX_VALUE,max(sub(i,j-1),sum[j]))
    // 2. 定义状态 dp[i][j] i个元素分成j组，各组和的最大值的最小值
    // 3. DP方程 dp(i,j) = min(dp(i,j),max(dp(k,j-1),sum[i]-sum[k]))

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        int[] sum = new int[n + 1];

        for(int i = 0; i <= n; i ++) {
            for(int j = 0; j <= m; j ++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < n; i ++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        dp[0][0] = 0;

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                for(int k = 0;k < i; k ++) {
                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[k][j - 1],sum[i] - sum[k]));
                }
            }
        }

        return dp[n][m];
    }
}
