package com.alang.learn.week6;

/***

 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

 示例:

 输入:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 输出: 4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximal-square
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_221_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        System.out.println(solution.maximalSquare(matrix));
        System.out.println(solution.maximalSquare1(matrix));
    }

    static class Solution {
        public int maximalSquare(char[][] matrix) {
            if (isEdgeCase(matrix)) return 0;
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] dp = new int[row + 1][col + 1];
            int maxLength = 0;
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                        maxLength = Math.max(maxLength, dp[i][j]);
                    }
                }
            }
            return maxLength * maxLength;
        }

        public int maximalSquare1(char[][] matrix) {
            if (isEdgeCase(matrix)) return 0;
            int row = matrix.length;
            int col = matrix[0].length;
            int[] dp = new int[col + 1];
            int maxLength = 0;
            int pre = 0;
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    int temp = dp[j];
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[j] = min(dp[j], dp[j - 1], pre) + 1;
                        maxLength = Math.max(maxLength, dp[j]);
                    } else {
                        dp[j] = 0;
                    }
                    pre = temp;
                }
            }
            return maxLength * maxLength;
        }

        private int min(int a, int b, int c) {
            return a > b ? (Math.min(b, c)) : (Math.min(a, c));
        }

        private boolean isEdgeCase(char[][] matrix) {
            return matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0;
        }
    }
}
