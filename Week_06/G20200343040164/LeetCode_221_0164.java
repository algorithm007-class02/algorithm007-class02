//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, pre = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1],pre),dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen,dp[j]);
                } else dp[j] = 0;
                pre = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * public int maximalSquare(char[][] matrix) {
 *         int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
 *         int[][] dp = new int[rows + 1][ cols + 1];
 *         int maxsqlen = 0;
 *         for (int i = 1; i <= rows; i++) {
 *             for (int j = 1; j <= cols; j++) {
 *                 if (matrix[i - 1][j - 1] == '1') {
 *                     dp[i][j] = Math.min(Math.min(dp[i][j - 1],dp[i - 1][j]),
 *                                 dp[i - 1][j - 1]) + 1;
 *                     maxsqlen = Math.max(maxsqlen,dp[i][j]);
 *                 }
 *             }
 *         }
 *         return maxsqlen * maxsqlen;
 *     }
 */
