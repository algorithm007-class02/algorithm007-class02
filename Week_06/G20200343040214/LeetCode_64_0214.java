package level2;

public class Solution64 {
    // 动态规划
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length <= 0)
            return 0;
        if (grid[0] == null || grid[0].length <= 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j] = grid[i][j]+ min(dp[i+1][j], dp[i][j+1])
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else if (i == 0)
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                else if (j == 0)
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                else
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public int minPathSum2(int[][] grid) {
        // 自底 而上的 深度搜索
        int row = grid.length;
        int col = grid[0].length;
        int[][] visited = new int[row][col];
        return DFS(grid, row - 1, col - 1, visited);
    }

    private int DFS(int[][] grid, int i, int j, int[][] visited) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (visited[i][j] != 0) {
            return visited[i][j];
        }
        int right = DFS(grid, i - 1, j, visited); // left
        int bottom = DFS(grid, i, j - 1, visited); // top
        visited[i][j] = grid[i][j] + Math.min(right, bottom);
        return visited[i][j];
    }
}
