package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/4/5 17:48
 * @Description:https://leetcode-cn.com/problems/number-of-islands/
 */
public class LeeCode_200_0226 {
    public int numIslands(char[][] grid) {
        int count = 0;

        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0;j < grid[i].length; j ++) {
                if(grid[i][j] == '1') {
                    count ++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
    }
}
