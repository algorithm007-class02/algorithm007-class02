package com.leetcode.search;

import java.util.*;

/**
 * 200. 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
 * 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 */
public class L200IslandNumber {

    public int numIslandsDfs(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int islandNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (searchIsLand(grid, i, j)) {
                    islandNum++;
                }
            }
        }

        return islandNum;
    }

    private boolean searchIsLand(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return false;
        }
        if (grid[i][j] == '0') {
            return false;
        }

        grid[i][j] = '0';
        searchIsLand(grid, i - 1, j);
        searchIsLand(grid, i + 1, j);
        searchIsLand(grid, i, j - 1);
        searchIsLand(grid, i, j + 1);
        return true;
    }

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int islandNum = 0;
        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        int[][] directions = new int[][] {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                rowQueue.add(i);
                colQueue.add(j);
                grid[i][j] = '0';

                islandNum++;

                while (!rowQueue.isEmpty()) {
                    int row = rowQueue.poll();
                    int column = colQueue.poll();

                    for (int k = 0; k < directions.length; k++) {
                        int rowDelta = directions[k][0];
                        int colDelta = directions[k][1];

                        int newRow = row + rowDelta;
                        int newCol = column + colDelta;
                        if (newRow < 0 || newRow >= grid.length ||
                                newCol < 0 || newCol >= grid[0].length) {
                            continue;
                        }
                        if (grid[newRow][newCol] == '0') {
                            continue;
                        }

                        grid[newRow][newCol] = '0';
                        rowQueue.add(newRow);
                        colQueue.add(newCol);
                    }
                }

            }
        }

        return islandNum;
    }
}
