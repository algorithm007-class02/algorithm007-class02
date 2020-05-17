package com.wxs.algorithm1.week09;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/16
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_188_0316 {
    public int maxProfit(int k, int[] prices) {
        if(prices.length < 1){
            return 0;
        }
        if(k > prices.length /2){

            int dp_i_0 = 0;
            int dp_i_1 = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1,dp_i_0 - prices[i]);
            }
            return dp_i_0;
        }

        int[][][] dp = new int[prices.length][k+1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j >= 1; j--) {
                if(i - 1 == -1){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }

                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] -prices[i]);
            }

        }

        return dp[prices.length-1][k][0];

    }
}
