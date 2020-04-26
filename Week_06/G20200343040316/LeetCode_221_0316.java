package com.wxs.algorithm1.week06;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-19
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_221_0316 {


    public static void main(String[] args) {


        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}

        };

        LeetCode_221_0316 maximalSquare221 = new LeetCode_221_0316();
        maximalSquare221.maximalSquare(matrix);


    }

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;

        int[][] dp = new int[rows+1][cols+1];

        int maxSqlen = 0;

        for (int i = 1; i <=rows; i++) {
            for (int j = 1; j <= cols; j++) {

                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1])+1;

                    maxSqlen = Math.max(maxSqlen, dp[i][j]);
                }

            }

        }

        return maxSqlen * maxSqlen;

    }

}
