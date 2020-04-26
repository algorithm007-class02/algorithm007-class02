/**
 * 不同路径
 */
public class LeetCode_62_0222 {

    /**
     * 动态规划，得i，j点可由左边和上边的点来 所以有dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 左边和上边边界设置为1
     * 时间复杂度：O(m*n)O(m∗n)
     * 空间复杂度：O(m * n)O(m∗n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 优化uniquePaths 用一个一维数组向下计算
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsRe(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}