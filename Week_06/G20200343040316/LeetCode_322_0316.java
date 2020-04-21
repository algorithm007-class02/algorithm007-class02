package com.wxs.algorithm1.week06;

import java.util.Arrays;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-18
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_322_0316 {


    public static void main(String[] args) {
        LeetCode_322_0316 coinChange322 = new LeetCode_322_0316();

        coinChange322.coinChange(new int[]{1, 2, 5},11);


    }


    public int coinChange(int[] coins, int amount) {

        int max = amount +1;

        int[] dp = new int[max];

        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {

            for (int j = 0; j < coins.length; j++) {

                if(coins[j] <= i){

                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }


            }

        }


        return dp[amount] > amount ? -1 : dp[amount];








    }


}
