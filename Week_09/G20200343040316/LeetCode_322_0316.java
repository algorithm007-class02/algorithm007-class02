package com.wxs.algorithm1.week09;

import java.util.Arrays;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-05-15
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_322_0316 {

    public static void main(String[] args) {
        LeetCode_322_0316 coinChange322 = new LeetCode_322_0316();
        int i = coinChange322.coinChange(new int[]{2}, 3);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {

                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }

            }

        }
        return dp[amount] > amount ? -1 : dp[amount];

    }
}
