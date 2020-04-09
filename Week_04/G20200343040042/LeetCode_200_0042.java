package com.yequan.leetcode.tree.numIslands_200;

/**
 * //给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
 * //网格的四个边均被水包围。
 * //
 * // 示例 1:
 * //
 * // 输入:
 * //11110
 * //11010
 * //11000
 * //00000
 * //
 * //输出: 1
 * //
 * //
 * // 示例 2:
 * //
 * // 输入:
 * //11000
 * //11000
 * //00100
 * //00011
 * //
 * //输出: 3
 * //
 * // Related Topics 深度优先搜索 广度优先搜索 并查集
 *
 * @author : Administrator
 * @date : 2020/4/4
 */
public class NumIslands {

    private int row = 0;
    private int column = 0;

    /**
     * 1.先遍历二维数组,找出 为 '1'的
     * 2.将为 '1'的周围的所有的 '1'置为 '0'
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        if (null == grid) {
            return 0;
        }
        row = grid.length;
        if(0==row){
            return 0;
        }
        column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ('1' == grid[i][j]) {
                    //将所grid[1][j]左右上下相邻的所有 '1' 置为0
                    markZero(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 标记为0
     *
     * @param grid
     * @param i
     * @param j
     */
    private void markZero(char[][] grid, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        //x方向: 前进一步
        markZero(grid, i + 1, j);
        //x方向: 后退一步
        markZero(grid, i - 1, j);
        //y方向: 向上一步
        markZero(grid, i, j + 1);
        //y方向: 向下一步
        markZero(grid, i, j - 1);
    }

}
