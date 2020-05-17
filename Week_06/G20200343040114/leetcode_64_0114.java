/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (65.00%)
 * Likes:    445
 * Dislikes: 0
 * Total Accepted:    77.8K
 * Total Submissions: 119.1K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[n][m];
        // i 表示行，j 表示列
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                // 最后一行初始化
                if (i == n - 1 && j != m - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (j == m - 1 && i != n - 1) {
                    // 最后一列初始化
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (i != n - 1 && j != m - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    // 右下角网格初始化
                    dp[i][j] = grid[i][j];
                }
            }
        }

        return dp[0][0];
    }
}
// @lc code=end
