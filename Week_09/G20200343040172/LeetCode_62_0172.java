package week09.g20200343040172;

public class LeetCode_62_0172 {
  /**
   * 使用动态规划
   */
  class Solution1 {
    public int uniquePaths(int m, int n) {
      int[][] dp = new int[m + 1][n + 1];
      for (int i = 0; i <= m; ++i) {
        dp[i][n] = 1;
      }
      for (int j = 0; j <= n; ++j) {
        dp[m][j] = 1;
      }
      for (int i = m - 1; i >= 1; --i) {
        for (int j = n - 1; j >= 1; --j) {
          dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
        }
      }
      return dp[1][1];
    }
  }
}
