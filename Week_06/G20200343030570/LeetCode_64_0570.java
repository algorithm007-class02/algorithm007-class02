class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        dp[0][0] = grid[0][0];
        
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                // 上边界 + 左边界，起始步
                if (i == 0 && j == 0)
                    continue;
                // 上边界：只能从左边dp[i][j - 1]到达dp[i][j]
                else if (i == 0)
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                // 左边界：只能从上边dp[i - 1][j]到达dp[i][j]
                else if (j == 0)
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                // 不触及边界，从上或从左到达，选一个最小的
                else
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        
        return dp[m - 1][n - 1];

    }
}
