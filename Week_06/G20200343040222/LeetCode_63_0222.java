public class LeetCode_63_0222 {

    /**
     * 改编自63题
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 0) {
            obstacleGrid[0][0] = -1;
        } else {
            obstacleGrid[0][0] = 0;
        }
        for (int i = 1; i < n && obstacleGrid[0][i - 1] < 0 && obstacleGrid[0][i] == 0; i++) {
            obstacleGrid[0][i] = -1;
        }
        for (int i = 1; i < m && obstacleGrid[i - 1][0] < 0 && obstacleGrid[i][0] == 0; i++) {
            obstacleGrid[i][0] = -1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    int top = obstacleGrid[i - 1][j] < 0 ? obstacleGrid[i - 1][j] : 0;
                    int left = obstacleGrid[i][j - 1] < 0 ? obstacleGrid[i][j - 1] : 0;
                    obstacleGrid[i][j] = top + left;
                }
            }
        }
        return obstacleGrid[m - 1][n - 1] < 0 ? -obstacleGrid[m - 1][n - 1] : 0;

    }

    /**
     * 改编自63题题解2
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstaclesRe(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }

}