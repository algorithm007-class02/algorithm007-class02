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
class LeetCode_221_0206 {
    //暴力求解,感觉都很难
    //遍历矩阵，找到1，就从1开始往下找矩形，0就跳过
    //怎么从1开始找矩形？找边长，然后遍历最长边长组成的长方形，看是否都是1

    //直接上动态规划
    //dp[i,j]表示以a[i,j]为右下角的正方形的最大边长
    //那就可以得出dp方程:dp[i,j] = min(dp[i-1,j], dp[i,j-1], dp[i-1,j-1]) + 1
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxSide = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                maxSide = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxSide = 1;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }

        return maxSide * maxSide;
    }

    //优化存储空间，使用一维dp方程
    public int maximalSquare_1(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int[] dp = new int[matrix[0].length + 1];
        int maxSide = 0;
        int pre = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                int temp = dp[j];
                if (matrix[i-1][j-1] == '1') {
                    dp[j] = Math.min(dp[j-1],Math.min(dp[j], pre)) + 1;
                    maxSide = Math.max(dp[j],maxSide);
                } else {
                    dp[j] = 0;
                }
                pre = temp;
            }
        }
        return maxSide * maxSide;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
