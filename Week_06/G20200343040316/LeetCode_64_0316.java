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

public class LeetCode_64_0316 {


    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        LeetCode_64_0316 minPathSum64 = new LeetCode_64_0316();
        int i = minPathSum64.minPathSum(arr);
        System.out.println(i);

    }

    public int minPathSum(int[][] grid) {

        // 最外层表示几条数据
        int row = grid.length;

        // 内层表示几列
        int col = grid[0].length;


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                // 如果i j 都从0开始考虑边界问题
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0 && i != 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }

        }
        return grid[row - 1][col - 1];
    }


    /**
     * 暴力破解 递归
     *
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        return helper(0, 0, grid);
    }

    private int helper(int row, int col, int[][] grid) {
        // 终止条件
        if (row == grid.length || col == grid[0].length) return Integer.MAX_VALUE;
        if (row == grid.length - 1 && col == grid[0].length - 1) return grid[row][col];
        return Math.min(helper(row + 1, col, grid), helper(row, col + 1, grid)) + grid[row][col];
    }
}
