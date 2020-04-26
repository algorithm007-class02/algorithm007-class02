package com.wxs.algorithm1.week07;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-24
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_200_0316 {


    public static void main(String[] args) {


    }


    public int numIslands(char[][] grid) {

        int res = 0;

        // 0 表示水， 1、表陆地 2、表示已经访问的陆地
      //  int[][] visited = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == '1' ){
                    dfs(grid,i,j);
                    res++;
                }

            }

        }

        return res;

    }

    private void dfs(char[][] grid, int row, int col) {

        if(!isArea(row,col,grid))return;

        if(grid[row][col] != '1')return;

        grid[row][col]= '2';

        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);

    }

    private boolean isArea(int row, int col, char[][] grid) {

        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;

    }


}
