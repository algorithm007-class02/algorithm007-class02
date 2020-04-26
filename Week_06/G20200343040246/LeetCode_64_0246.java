package Week_06.G20200343040246;

public class LeetCode_64_0246 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int ans = new LeetCode_64_0246().minPathSum(grid);
        System.out.println(ans);
    }
    
    // 子问题：到达位置i,j的最小路径和是多少？
    // 状态定义：dp[i][j] 位置i,j的最小路径和
    // DP方程：dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for(int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}