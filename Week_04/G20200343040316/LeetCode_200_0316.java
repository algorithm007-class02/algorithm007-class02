package com.wxs.algorithm1.week04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-05
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_200_0316 {


    public int numIslands(char[][] grid) {


        if(grid == null || grid.length == 0){
            return 0;
        }


        int length = grid.length;
        int high = grid[0].length;

        int counter = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < high; j++) {

                if(grid[i][j] == '1'){
                    counter++;
                    bfs(grid,i,j);
                }

            }

        }

        return counter;
    }

    private void bfs(char[][] grid, int i, int j) {


        int lengh = grid.length;
        int high = grid[i].length;

        if(i < 0 || j <0 || i >= lengh || j >= high || grid[i][j] != '1'){
            return;
        }

        grid[i][j] = '0';

        bfs(grid,i+1,j);
        bfs(grid,i-1,j);

        bfs(grid,i,j + 1);
        bfs(grid,i,j - 1);

    }



    public int numIslands1(char[][] grid) {

        if(grid == null || grid.length == 0){
            return 0;
        }


        int length = grid.length;
        int high = grid[0].length;

        int counter = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < high; j++) {

                if(grid[i][j] == '1'){
                    Queue<Integer> neighbors = new LinkedList<>();

                    neighbors.add(i * high + j);


                }

            }

        }

        return counter;




    }


}
