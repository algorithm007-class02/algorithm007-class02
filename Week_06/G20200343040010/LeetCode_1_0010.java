package com.algorithm.fifthWeek;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(minPathSum(grid));
    }

    /**
     * 采用倒退的方式累加，那么最后第一个元素就是结果
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        for(int i = grid.length-1; i >=0; i--) {
            for(int j = grid[i].length-1; j >= 0; j--) {
                if(i == grid.length-1 && j != grid.length-1) {
                    grid[i][j] = grid[i][j] + grid[i][j+1];
                } else if(i != grid.length-1 && j == grid[i].length-1) {
                    grid[i][j] = grid[i+1][j] + grid[i][j];
                } else if(i != grid.length-1 && j != grid[i].length-1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i+1][j], grid[i][j+1]);
                }
            }
        }

        return grid[0][0];
    }
}
