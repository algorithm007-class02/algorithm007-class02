package com.alang.learn.week6;

/***

 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

 说明：每次只能向下或者向右移动一步。

 示例:

 输入:
 [
 [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 输出: 7
 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class LeetCode_64_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(solution.minPathSum(nums));
        nums = new int[][]{};
        System.out.println(solution.minPathSum(nums));
    }

    static class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
            int row = grid.length;
            int col = grid[0].length;
            int[] dp = new int[col + 1];
            dp[0] = 0;
            for (int i = 0; i < col; i++) {
                dp[i + 1] = dp[i] + grid[0][i];
            }
            for (int i = 1; i < row; i++) {
                dp[0] = dp[1];
                for (int j = 1; j <= col; j++) {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j - 1];
                }
            }
            return dp[col];
        }
    }
}
