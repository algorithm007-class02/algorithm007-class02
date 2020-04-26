package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/4/19 16:53
 * @Description:
 */
public class LeeCode_64_0226 {

    public int minPathSum(int[][] grid) {

        //  1.重复子问题  problem(i,j) = min(sub(i,j-1),sub(i-1,j)) + grid[i][j]
        //  2.定义状态数组
        //  3.DP方程
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i < m; i++) {
            for(int j = 0;j < n; j ++) {
                if(i == 0 & j == 0) {
                    grid[i][j] = grid[i][j];
                }else if(i == 0) {
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                }else if(j == 0) {
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                }else{
                    grid[i][j] = Math.min(grid[i][j - 1],grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        return grid[m-1][n-1];
    }
}
