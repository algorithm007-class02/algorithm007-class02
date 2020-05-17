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

public class LeetCode_121_gp_0316 {

    /**
     * 分析状态转移方程
     * <p>
     * int[][] dp ;
     * dp[i][0] = dp[i-1][0] ,dp[i-1][1] + price
     * dp[i][1] = dp[i-1][1] ,dp[i-1][0] - price
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);

        }

        return dp[prices.length - 1][0];
    }


    public int maxProfit1(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }

        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    int maxProfit_k_inf(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);

            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);

        }

        return dp_i_0;
    }

    /**
     * 309题
     *
     * @param prices
     * @return
     */
    int maxProfit_with_cool(int[] prices) {

        if (prices.length < 1) {
            return 0;
        }

        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];

        int dp_pre_0 = 0; // 前两天未持有的价值 dp[i-1][0]

        for (int i = 1; i < prices.length; i++) {

            int temp = dp_i_0;

            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);

            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);

            dp_pre_0 = temp;
        }
        return dp_i_0;

    }


    public int maxProfit(int[] prices, int fee) {

        if (prices.length < 1) {
            return 0;
        }

        int dp_i_0 = 0;
        int dp_i_1 = -prices[0] - fee;

        for (int i = 0; i < prices.length; i++) {

            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);

            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i] - fee);

        }
        return dp_i_0;
    }


    public int maxPr(int[] prices) {

        int max_k = 2;

        if (prices.length < 1) {
            return 0;
        }

        int[][][] dp = new int[prices.length][max_k + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);

            }
        }
        return dp[prices.length - 1][max_k][0];
    }



}
