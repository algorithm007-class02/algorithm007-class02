package com.cactus.cyc.leetcode.sevenweek;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:
 * @decription:
 * @time:
 */
public class SevenWeek {

    private int m;
    private int n;

    /**
     * 爬楼梯
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (1 == n) return 1;
        int[] sta = new int[n + 1];
        sta[1] = 1;
        sta[2] = 2;
        for (int i = 3; i <= n; i++) {
            sta[i] = sta[i - 1] + sta[i - 2];
        }
        return sta[n];
    }

    /**
     * 岛屿数量
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String str, int open, int close, int max){
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

}
