import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row: obstacleGrid) {
            for (int j = 0; j < width; ++j) {
                if (row[j] == 1) dp[j] = 0;
                else if (j > 0) dp[j] += dp[j-1];
            }
        }
        return dp[width-1];
    }
}
// @lc code=end

