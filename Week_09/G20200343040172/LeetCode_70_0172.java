package week09.g20200343040172;

public class LeetCode_70_0172 {
  /**
   * 动态规划
   */
  class Solution {
    public int climbStairs(int n) {
      int[] dp = new int[n + 2];
      dp[1] = 1;
      dp[2] = 2;
      for (int i = 3; i <= n; ++i) {
        dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n];
    }
  }
}
