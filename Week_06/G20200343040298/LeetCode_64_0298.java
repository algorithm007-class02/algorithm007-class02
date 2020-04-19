/*
* leetcode 64.最小路径和
* 定义上下边界减少重复判断
*/
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1;i <= Math.max(m,n)-1;i++){
            if (i < m) dp[i][0] = grid[i][0] + dp[i-1][0];
            if (i < n) dp[0][i] = grid[0][i] + dp[0][i-1];
        }

        for (int i = 1;i <= m-1;i++){
            for (int j = 1;j <= n-1;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
