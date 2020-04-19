package module01;

import java.util.Arrays;

/**
 * @author JiaYunFei
 * @date 2020/4/1 21:32
 */

//动态规划 自下而上
public class CoinChange_322 {
    public static void main(String[] args) {
        int[] nums = {1};
        int mount = 2;
        int res = coinChange(nums, mount);
        System.out.println(res);
    }

    private static int coinChange(int[] coins, int amount) {
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
