package com.alang.learn.week9;

public class LeetCode_63_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
       System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0,1}}));
        System.out.println(solution.uniquePathsWithObstacles1(new int[][]{{0,1}}));
    }
    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
            int row = obstacleGrid.length;
            if(obstacleGrid[0] == null || obstacleGrid[0].length == 0) return 0;
            int col = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1) return 0;
            int[][] dp = new int[row][col];
            dp[0][0] = 1;
            for (int i = 1; i < row; i++) {
                if (obstacleGrid[i][0] == 1) {
                    break;
                } else {
                    dp[i][0] = 1;
                }
            }
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[0][j] == 1) {
                    break;
                } else {
                    dp[0][j] = 1;
                }
            }

            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i][j - 1] + dp[i - 1][j];
                }
            }
            return dp[row - 1][col - 1];
        }
        //dp[i][j] = obstacleGrid[i][j] == 1 ?0:dp[i-1][j]+dp[i][j-1]


        public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
            if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
            int row = obstacleGrid.length;
            if(obstacleGrid[0] == null || obstacleGrid[0].length == 0) return 0;
            int col = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1) return 0;
            int[] dp = new int[col];
            dp[0] = 1;
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[0][j] == 1) {
                    break;
                } else {
                    dp[j] = 1;
                }
            }
            for (int i = 1; i < row; i++) {
                dp[0] = obstacleGrid[i][0] == 1?0:dp[0];
                for (int j = 1; j < col; j++) {
                    dp[j] = obstacleGrid[i][j] == 1 ? 0 :  dp[j]+dp[j-1];
                }
            }
            return dp[col - 1];
        }
    }
}
