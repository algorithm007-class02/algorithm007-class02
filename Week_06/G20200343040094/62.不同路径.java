import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++) dp[0][i] = 1;
        for(int i = 0; i < m; i++) dp[i][0] = 1;
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

// 优化，空间复杂度O(m)
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; ++i){
            for(int j = 1; j < m; ++j){
                dp[j] += dp[j-1];
            }
        }
        return dp[m-1];
    }
}
// @lc code=end

