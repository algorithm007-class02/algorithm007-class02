package week06.g20200343040172;

import java.util.Arrays;

public class LeetCode_322_0172 {

    /**
     * 自顶向下的动态规划
     * 感觉主要就是递归
     */
    class Solution1 {

        public int coinChange(int[] coins, int amount) {
            if (amount < 1) {
                return 0;
            }
            return coinChange(coins, amount, new int[amount]);
        }

        /**
         *
         * @param coins 硬币的面值
         * @param rem 剩下的钱的总额
         * @param count memo数组，加速递归
         * @return 组成当前面额的钱所需的最少硬币数
         */
        private int coinChange(int[] coins, int rem, int[] count) {
            if (rem < 0) {
                return -1;
            }
            if (rem == 0) {
                return 0;
            }
            if (count[rem - 1] != 0) {
                return count[rem - 1];
            }
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChange(coins, rem - coin, count);
                if (res >= 0 && res < min) {
                    min = 1 + res;
                }
            }
            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
            return count[rem - 1];
        }
    }

    /**
     * 自底向上的动态规划
     */
    class Solution2 {
        /*
            输入: coins = [1, 2, 5], amount = 11
            输出: 3
            解释: 11 = 5 + 5 + 1
        */
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}


