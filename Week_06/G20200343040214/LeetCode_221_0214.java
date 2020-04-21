package level2;

public class Solution221 {
    public static void main(String[] args) {

    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length <= 0)
            return 0;
        if (matrix[0] == null || matrix[0].length <= 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLength = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    // 为什么采用 min
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength * maxLength;
    }
}
